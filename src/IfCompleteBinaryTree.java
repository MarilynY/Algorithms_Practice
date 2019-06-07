import java.util.LinkedList;
import java.util.Queue;

public class IfCompleteBinaryTree {
}

/*
key point: once the null is detected, return false if you detect number again
data structure: FIFO queue
                flag to detect null
Algorithm: Breadth First Search
Initialize: enqueue root
Expand: dequeue the 1st of queue
Generate: enqueue all the children of that elements
    case 1: if the flag is off, left or right child is null, set the flag on
    case 2: if the flag is on, left or right child is not null, return false
Termination: queue is empty or return false in generation process
dedup: no need
*/
class IfCompleteBinaryTreeSolution {
    public boolean isCompleted(TreeNode root) {
        //corner case
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //Once flag is set to true, there should not have child nodes afterwards
        boolean flag = false;
        //Initialize
        queue.offer(root);
        //termination
        while (!queue.isEmpty()) {
            //Expand
            TreeNode curr = queue.poll();
            //Generate
            if (flag == false) {
                if (curr.left == null && curr.right != null) {
                    return false;
                }
                if (curr.left != null && curr.right == null) {
                    queue.offer(curr.left);
                    flag = true;
                }
                if (curr.left != null && curr.right != null) {
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
                if (curr.left == null && curr.right == null) {
                    flag = true;
                }
            } else {
                if (curr.left != null || curr.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
}