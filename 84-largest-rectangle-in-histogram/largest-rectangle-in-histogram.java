class Solution {
    public int largestRectangleArea(int[] heights) {
     Stack<Integer> st=new Stack<>();
     int n=heights.length;
     int maxArea=0;
     for(int i=0;i<n;i++){
        while(!st.isEmpty() && heights[st.peek()]>heights[i]){
            int element=st.peek();
            st.pop();
            int nsc=i;
            int psc = st.isEmpty() ? -1 : st.peek();
            int area=heights[element]*(nsc-psc-1);
            maxArea=Math.max(maxArea,area);
        }
        st.push(i);
     }
     while(!st.empty()){
        int element=st.peek();
        st.pop();
        int nsc=n;
        int psc=st.empty()?-1:st.peek();
        int area=heights[element]*(nsc-psc-1);
        maxArea=Math.max(maxArea, area);
     }
     return maxArea;
    }
}