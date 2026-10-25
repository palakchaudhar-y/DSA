class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;

         
            if(n==0){
                List<List<Integer>> bres=new ArrayList<>();
                bres.add(new ArrayList<>());
                return bres;
            }
         
        int a=nums[0];
        int[] roa=Arrays.copyOfRange(nums,1,n);

        List<List<Integer>> rres=subsets(roa);
        List<List<Integer>> mres=new ArrayList<>();
        for (List<Integer> rlist : rres) {
            mres.add(new ArrayList<>(rlist));

            List<Integer> temp = new ArrayList<>(rlist);
            temp.add(0, a);
            mres.add(temp);
        }
    return mres;
    }
}