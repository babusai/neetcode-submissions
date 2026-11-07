class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int front = 0;
        int back = heights.length - 1;

        int waterQty;
        int height;

        while (front < back) {
            if (heights[front] < heights[back]) {
                waterQty = (back - front) * heights[front];
                front++;
            } else {
                waterQty = (back - front) * heights[back];
                back--;
            }

            max = Math.max(max, waterQty);
        }

        return max;
    }
}
