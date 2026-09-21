class Solution {
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

            st.push(i);
        }

        return maxArea;
    }
}