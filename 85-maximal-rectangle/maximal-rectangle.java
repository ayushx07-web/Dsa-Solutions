class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] arr = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(arr));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int nse = heights.length;
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }
        return maxArea;
    }
}
