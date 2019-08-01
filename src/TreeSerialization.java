public class TreeSerialization {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(12);
//        root.right.right = new TreeNode(20);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        TreeSerializationSolution test = new TreeSerializationSolution ();
        TreeNode res = test.toDoubleLinkedList(root);

        //验证next指针
        //打印出 3 2 1
        TreeNode head = res;
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.right;
        }
        System.out.println("");

        //验证prev指针
        //打印出 1 2 3
        while (res != null && res.right != null) {
            res = res.right;
        }
        while (res != null) {
            System.out.print(res.key + " ");
            res = res.left;
        }
    }
}
class TreeSerializationSolution {
    static TreeNode prev;
    public TreeNode toDoubleLinkedList(TreeNode root) {
        // Write your solution here.
        if (root == null) {
            return null;
        }
        findPrevPointer(root);
        return findNextPointer(root);
    }
    private void findPrevPointer(TreeNode root) {
        if (root == null) {
            return;
        }
        findPrevPointer(root.left);
        root.left = prev;
        prev = root;
        findPrevPointer(root.right);
    }
    private TreeNode findNextPointer(TreeNode root) {
        //to find the right most node in the linked list we just created
        while (root != null && root.right != null) {
            root = root.right;
        }

        root.right = null;
        while (root != null && root.left != null) {
            // TreeNode temp = new TreeNode(0);
            // temp = root.left;
            root.left.right = root;
            root = root.left;
        }
        return root; //head of linkedList
    }
}