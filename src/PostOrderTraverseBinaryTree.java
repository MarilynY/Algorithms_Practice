import sun.reflect.generics.tree.Tree;

import java.util.*;

public class PostOrderTraverseBInaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(7);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        TreeNode n5 = new TreeNode(15);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(20);
        n1.right = n5;
        n5.left = n6;
        n5.right = n7;

        PostOrderTraverseIterativelyMethod1 test1 = new PostOrderTraverseIterativelyMethod1();
        List<Integer> result = test1.preOrderTraverseIteratively(n1);
        for (int x : result) {
            System.out.print(x + " ");
        }

        PostOrderTraverseRecursively test2 = new PostOrderTraverseRecursively();
        List<Integer> result2 = test2.postOrder(n1);
        System.out.println();
        for (int x : result2) {
            System.out.print(x + " ");
        }

        PostOrderTraverseIterativelyMethod2 test3 = new PostOrderTraverseIterativelyMethod2();
        List<Integer> result3 = test3.postOrder2(n1);
        System.out.println();
        for (int x : result3) {
            System.out.print(x + " ");
        }
    }
}

//Recursively
//Time: O(n)
//Space: O(h)
class PostOrderTraverseRecursively {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //corner case
        if (root == null) {
            return res;
        }
        postOrder(root, res);
        return res;
    }
    private void postOrder(TreeNode root, List<Integer> res) {
        //base case
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        //recursive rule
        res.add(root.key);
    }
}

//Iteratively method 1: reverse preOrder traverse with traversing left subtree before right subtree
//why？  preorder： self, left, right
//       postorder: left, right, self
//       so we need to turn preorder to self, right, left, then reverse it to left, right, self
//Time: O(n)
//Space：O(layer with most nodes)
class PostOrderTraverseIterativelyMethod1 {
    public List<Integer> preOrderTraverseIteratively(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //corner case
        if (root == null) {
            return res;
        }
        return preOrderTraverseIteratively(root, res);
    }
    private List<Integer> preOrderTraverseIteratively(TreeNode root, List<Integer> res) {
        Deque<TreeNode> stack = new LinkedList<>();
        //initialization
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            //pointer
            TreeNode curr = stack.pollFirst();
            res.add(curr.key);
            //we must traverse left subtree before right subtree
            if (curr.left != null) {
                stack.offerFirst(curr.left);
            }
            if (curr.right != null) {
                stack.offerFirst(curr.right);
            }
        }
        //O（n）
        Collections.reverse(res);
        return res;
    }
}

//Iteratively method 2
//use prev and curr pointer to see the relationship between two nodes
//to determine how to move next
/*
when can we traverse the curr node ??
    case 1: when it is a leaf node
    case 2: when it is node a leaf node, but curr pointer moved up from right subtree
    case 3: when the curr pointer moved up from left but curr.right == null

How many situations could have when traverse the tree??
    case 1: moving from top to bottom either to left subtree or right subtree
            (prev == null || curr == prev.left || curr = prev.right)
        case 1.1: left != null -> stack.offerFirst(curr.left)
        case 1.2: right != null -> stack.offerFirst(curr.right)
        case 1.3: left == null && right == null -> leaf node -> stack.pollFirst(), res.add(curr.key)
    case 2: moving from bottom to top from right or from left but can not move down to the right any more
            (prev == curr.right || prev == curr.left && curr.right == null)
        stack.pollFirst(), res.add(curr.key)
    case 3: moving from bottom to top from left and still can move down to the right
        stack.offerFirst(curr.right)

    prev == curr
Termination condition: stop when stack is empty

Time: O(n)
Space: O(h) = O(logn) on average and O(n) on worst
*/
class PostOrderTraverseIterativelyMethod2 {
    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //corner case
        if (root == null) {
            return res;
        }
        TreeNode prev = null;
        //TreeNode curr = root; 这句话不能写在外面，否则curr cannot be updated
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            //curr should be initialized here
            TreeNode curr = stack.peek();
            if (prev == null || curr == prev.left || curr == prev.right) {
                if (curr.left != null) {
                    stack.offerFirst(curr.left);
                } else if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    stack.pollFirst();
                    res.add(curr.key);
                }
            } else if (prev == curr.right || prev == curr.left && curr.right == null) {
                stack.pollFirst();
                res.add(curr.key);
            } else {
                stack.offerFirst(curr.right);
            }
            prev = curr;
        }
        return res;
    }
}