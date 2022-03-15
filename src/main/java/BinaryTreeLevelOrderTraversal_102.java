import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> current = new LinkedList<Integer>();
            LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                current.add(node.val);

                if(node.left!=null) tmp.add(node.left);
                if(node.right!=null) tmp.add(node.right);
            }
            res.add(current);
            queue.addAll(tmp);
        }
        return res;
    }

    //dfs
    public List<List<Integer>> levelOrder_recursion(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        return res;
        //TODO
    }

    private void levelOrderHelper(TreeNode root, List<List<Integer>> res) {
        if(root==null) return;
    }
}
