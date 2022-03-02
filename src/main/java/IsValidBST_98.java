import java.util.TreeMap;


/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 * Solution 1: 中序遍历->升序
 * Solution 2: 左下右大
 */
public class IsValidBST_98 {
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
    public class Solution_1 {
        TreeNode pre = null;
        public boolean isValidBST(TreeNode root) {

            return validate(root);
        }

        public boolean validate(TreeNode root) {
            if(root==null)
                return true;

            if(!validate(root.left)) return false;

            if(pre!=null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            return validate(root.right);
        }
    }

    public class Solution_2 {
        public boolean isValidBST(TreeNode root) {

            return validate(root, null, null);
        }

        public boolean validate(TreeNode root, Integer min, Integer max) {
            if(root==null)
                return true;

            if(min!=null && root.val<min) return false;

            if(max!=null && root.val>max) return false;

            return validate(root.left, min, root.val) && validate(root.right, root.val, max);
        }
    }

}
