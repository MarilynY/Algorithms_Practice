import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTreeLevelByLevel {
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

        PrintBinaryTreeLevelByLevelSol test = new PrintBinaryTreeLevelByLevelSol();
        List<List<Integer>> res = test.layerByLayer(n1);
        for (List<Integer> L : res) {
            System.out.println(L);
        }
    }
}

class PrintBinaryTreeLevelByLevelSol {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        //corner case
        if (root == null) {
            return res;
        }
        layerByLayer(root, res);
        return res;
    }
    private void layerByLayer(TreeNode root, List<List<Integer>> res) {
        Queue<TreeNode> q = new LinkedList<>();
        //initialize
        q.offer(root);
        while (!q.isEmpty()) {
            //每轮过后需要清空，所以写在循环里面
            List<Integer> layerRes = new LinkedList<>();
            int oldSize = q.size();
            for (int i = 0; i < oldSize; i++) {
                TreeNode curr = q.peek();
                //expand
                layerRes.add(q.poll().key);
                //generate
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            res.add(layerRes);
        }
    }
}
