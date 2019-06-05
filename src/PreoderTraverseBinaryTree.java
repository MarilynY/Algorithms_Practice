import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreoderTraverseBinaryTree {
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

        TraverseRecursively test1 = new TraverseRecursively();
        List<Integer> result = test1.preOrderTraverseRecursively(n1);
        for (int x : result) {
            System.out.print(x + " "); //10 5 2 7 15 12 20
        }

        TraverseIteratively test2 = new TraverseIteratively();
        List<Integer> result2 = test2.preOrderTraverseIteratively(n1);
        System.out.println();
        for (int x : result2) {
            System.out.print(x + " "); //10 5 2 7 15 12 20
        }
    }
}
//BFS
//Time: O(n)
//Space: O(number of nodes of the most nodes layer)
class TraverseIteratively {
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
            //The left subtree should be traversed before the right subtree
            //since the stack is LIFO, so we should push right into the stack first
            //so for the next step, the top element of stack is the left subtree
            if (curr.right != null) {
                stack.offerFirst(curr.right);
            }
            if (curr.left != null) {
                stack.offerFirst(curr.left);
            }

        }
        return res;
    }
}

//DFS
//Time: o(n)
//Space: O(height) = O(logn) on average, o(n) on worst
class TraverseRecursively {
    public List<Integer> preOrderTraverseRecursively(TreeNode root) {
        //corner case
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traverseRecursively(root, res);
        return res;
    }
    private void traverseRecursively(TreeNode root, List<Integer> res) {
        //base case
        if (root == null) {
            return;
        }
        //recursive rule
        res.add(root.key);
        //subproblem
        traverseRecursively(root.left, res);
        traverseRecursively(root.right, res);
    }
}

