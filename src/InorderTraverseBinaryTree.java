import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraverseBinaryTree {
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

        InorderTraverseIteratively test1 = new InorderTraverseIteratively();
        List<Integer> result = test1.inOrder(n1);
        for (int x : result) {
            System.out.print(x + " "); //10 5 2 7 15 12 20
        }

        InorderTraverseRecursively test2 = new InorderTraverseRecursively();
        List<Integer> result2 = test2.inOrder(n1);
        System.out.println();
        for (int x : result2) {
            System.out.print(x + " "); //10 5 2 7 15 12 20
        }
    }
}

/*Iteratively
  Data structure: stack

  Time: O(n)
  Space: O(h), O(logn) on average, O(n) on worst for stack
*/

class InorderTraverseIteratively {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //Initilization
        TreeNode curr = root;
        //Termination condition: when curr == null && stack.isEmpty()
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                //always try to go left side to see if there is any node
                //should be traversed before the curr node, curr node is stored
                //on stack since it has not been traversed yet
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                //if can not go left, meaning all the nodes on the left side of
                //the top node on stack have been traversed, the next traversing node
                //should be the top node on stack
                curr = stack.pollFirst(); //the curr pointer will move to that node directly
                res.add(curr.key);
                //The next subtree we want to traverse is curr.right
                curr = curr.right;
            }
        }
        return res;
    }
}

//Recursively
//Time: O(n)
//Space: O(h): O(logn) on average, O(n) on worst
class InorderTraverseRecursively {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //corner case
        if (root == null) {
            return res;
        }
        inOrder(root, res);
        return res;
    }
    private void inOrder(TreeNode root, List<Integer> res) {
        //base case
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        //recursive rule
        res.add(root.key);
        inOrder(root.right, res);
    }
}