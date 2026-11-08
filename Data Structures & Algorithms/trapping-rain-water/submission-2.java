class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];

        int max = 0;
        for (int index = 0; index < height.length; index++) {
            max = Math.max(max, height[index]);
            prefix[index] = max;
        }

        max = 0;
        for (int index = height.length - 1; index >= 0; index--) {
            max = Math.max(max, height[index]);
            suffix[index] = max;
        }

        int totalTrappedWater = 0;
        for (int index = 0; index < height.length; index++) {
            totalTrappedWater += (Math.min(prefix[index], suffix[index]) - height[index]);
        }

        return totalTrappedWater;
    }
}
