class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
     Stack<Integer> st=new Stack<>();
     int n=temperatures.length;
     int arr[]=new int[n];
     
     for(int i=0;i<n;i++){
        int ans=temperatures[i];
        while(!st.isEmpty() && temperatures[st.peek()]<ans){
            int index=st.pop();
            arr[index]=i-index;
        }
        
        st.push(i);
     }  
     return arr; 
    }
}