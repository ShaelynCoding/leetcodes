public class MinimumDepthOfBinaryTree_111 {

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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return  1;
        int ans = Integer.MAX_VALUE;
        if(root.left!=null) {
            ans = min(ans, minDepth(root.left));
        }
        if(root.right!=null) {
            ans = min(ans, minDepth(root.right));
        }
        return 1+ans;
    }

    private int min(int a, int b) {
        if(a<b) return a;
        return b;
    }
}
