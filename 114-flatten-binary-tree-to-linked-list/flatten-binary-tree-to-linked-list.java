class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<TreeNode> a = new ArrayList<>();
        pre(root, a);
        for(int i = 0; i < a.size()-1; i++) {
            TreeNode curr = a.get(i);
            curr.left = null;
            curr.right = a.get(i+1);
        }
        TreeNode last = a.get(a.size()-1);
        last.left = null;
        last.right = null;
    }
    public void pre(TreeNode root, List<TreeNode> a) {
        if(root == null) return;
        a.add(root);
        pre(root.left, a);
        pre(root.right, a);
    }
}