class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='0'){
                    heights[j] = 0;
                }else{
                    heights[j]++;
                }
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
        }
        public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currHeight;
            if (i == heights.length) {
                currHeight = 0;
            } else {
                currHeight = heights[i];
            }
            while (!st.isEmpty() && heights[st.peek()] > currHeight) {
                int element = st.pop();
                int nsc = i;
                int psc = st.isEmpty() ? -1 : st.peek();
                int width = nsc - psc - 1;
                int area = heights[element] * width;
                maxArea = Math.max(maxArea, area);
           }
            if (i < heights.length) {
                st.push(i);
            }
        }
        return maxArea;
    }
}