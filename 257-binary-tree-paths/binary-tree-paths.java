class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
     List<String> ans = new ArrayList<>();
        solve(root, "", ans);
        return ans;   
    }
    public void solve(TreeNode root,String path,List<String> ans){
        if(root==null) return ;
        path=path+root.val;
        if(root.left==null && root.right==null){
            ans.add(path);
            return;
        }
        path = path + "->";
        solve(root.left, path, ans);
        solve(root.right, path, ans);
    }
}