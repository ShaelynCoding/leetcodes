/**
 * 给定一个二叉搜索树 (二叉树), 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 二叉树
 * Solution 1: 从root到p/q的path,看最后一个共同点
 * Solution 2: dfs看左右子树有没有p或q，都有return root
 * 二叉搜索树
 * Solution 1: 看p/q是否在同一边，如果分为在左右子树=>最近祖先为root
 */
public class LowestCommonAncestor_235_236 {
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
    public TreeNode lowestCommonAncestor_binarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val-root.val)*(q.val-root.val) <= 0) { //=0 => 一个节点也可以是它自己的祖先
            return root;
        } else if(p.val < root.val) {
            return lowestCommonAncestor_binarySearchTree(root.left, p, q);
        } else {
            return lowestCommonAncestor_binarySearchTree(root.right, p, q);
        }
    }

    public TreeNode lowestCommonAncestor_binaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) { //=0 => 一个节点也可以是它自己的祖先
            return root;
        }
        TreeNode left = lowestCommonAncestor_binaryTree(root.left, p, q);
        TreeNode right = lowestCommonAncestor_binaryTree(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else
            return right;
    }
}
