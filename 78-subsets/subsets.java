class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            int size=ans.size();
            for(int j=0;j<size;j++){
                List<Integer> temp=new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}