public class isBalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root1 = null;
        TreeNode root2 = new TreeNode(10);
        TreeNode root3 = new TreeNode(20);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(15);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(20);
        TreeNode n8 = new TreeNode(5);
        TreeNode n9 = new TreeNode(2);
        TreeNode n10 = new TreeNode(7);
        TreeNode n11 = new TreeNode(15);
        TreeNode n12 = new TreeNode(12);


        //balanced
        root2.left = n2;
        n2.left = n3;
        n2.right = n4;
        root2.right = n5;
        n5.left = n6;
        n5.right = n7;

        //not balanced
        root3.left = n8;
        n8.right = n9;
        n9.right = n10;
        root3.right = n11;
        n11.left = n12;


        isBalancedBinaryTreeSol test = new isBalancedBinaryTreeSol();
        System.out.println(test.isBalanced(root1));
        System.out.println(test.isBalanced(root2));
        System.out.println(test.isBalanced(root3));
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
        //left and right subtree are balanced && diff(left,right) <= 1
        if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}