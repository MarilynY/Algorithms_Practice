public class isBalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(7);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        //TreeNode n5 = new TreeNode(15);
        //TreeNode n6 = new TreeNode(12);
        //TreeNode n7 = new TreeNode(20);
        //n1.right = n5;
        //n5.left = n6;
        //n5.right = n7;

        isBalancedBinaryTreeSol test = new isBalancedBinaryTreeSol();
        boolean res = test.isBalanced(n1);
        System.out.println(res);
    }
}

class isBalancedBinaryTreeSol {
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0 ? true : false;
    }
    private int helper(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}