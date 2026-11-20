class Solution {
    TreeNode node = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);
        root.right = node;
        root.left = null;
        node = root;    
    }
}