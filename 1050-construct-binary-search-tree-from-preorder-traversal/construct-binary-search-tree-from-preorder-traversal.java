class Solution {
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
      return build(preorder,Integer.MAX_VALUE);
    }
    public TreeNode build(int[] preorder,long bound){
        if(i==preorder.length || preorder[i]>bound) return null;
        TreeNode root=new TreeNode(preorder[i]);
        i++;
        root.left=build(preorder,root.val);
        root.right=build(preorder,bound);
        return root;
    }
}