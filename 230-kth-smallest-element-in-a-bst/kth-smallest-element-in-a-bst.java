class Solution {
    int cnt=0;
    int ans=-1;
    public int kthSmallest(TreeNode root, int k) {
      in(root,k);
      return ans;
    }
    public void in(TreeNode root, int k){
        if(root==null) return;
        in(root.left,k);
        cnt++;
        if(cnt==k){
            ans=root.val;
            return;
        }
        in(root.right,k);
    }
}