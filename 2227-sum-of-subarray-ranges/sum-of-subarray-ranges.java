class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long sumMax=0;
        long sumMin=0;

        Stack<Integer> st=new Stack<>();
        int pse[]=new int[n];
        int nse[]=new int[n];

        //pse
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();

        //nse
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            sumMin+=(long) nums[i]*left*right;
        }

        //maxsum
        st.clear();

        int pge[]=new int[n];
        int nge[]=new int[n];

        //pge
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i]=-1;
            }else{
                pge[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();

        //nge
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            sumMax+=(long) nums[i]*left*right;
        }
        return sumMax-sumMin;
    }
}