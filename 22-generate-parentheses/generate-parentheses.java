class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
            solve(n,0,0,"",ans);
            return ans;
        }
        public void solve(int n,int open,int close,String path,List<String> ans){
        if(path.length()==2*n){
            ans.add(path);
            return;
        }
        if(open<n){
            solve(n,open+1,close,path +"(",ans);
        }
        if(close<open){
            solve(n,open,close+1,path +")",ans);
        }
    }
}