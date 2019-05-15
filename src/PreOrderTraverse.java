import java.util.LinkedList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

public class PreOrderTraverse {
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

       PreOrderTraverseSolution.preOrder(n1);


    }
}
class PreOrderTraverseSolution {
    public static void preOrder(TreeNode root) {
        // Write your solution here
        if (root == null) {
           return;
        }
        //logic
        System.out.print(root.key + " ");
        //left subtree
        preOrder(root.left);
        //right subtree
        preOrder(root.right);
    }
}
