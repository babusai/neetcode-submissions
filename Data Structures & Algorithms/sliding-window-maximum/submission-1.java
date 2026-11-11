class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> sortedFrequencyMap = new TreeMap<>();
        for (int index = 0; index < k; index++) {
            sortedFrequencyMap.put(
                nums[index], sortedFrequencyMap.getOrDefault(nums[index], 0) + 1);
        }
        result[0] = sortedFrequencyMap.lastKey();
        for (int index = 1; index + k <= nums.length; index++) {
            if(sortedFrequencyMap.get(nums[index - 1]) == 1) {
                sortedFrequencyMap.remove(nums[index - 1]);
            } else {
                sortedFrequencyMap.put(nums[index - 1], sortedFrequencyMap.get(nums[index - 1]) - 1);
            }
            sortedFrequencyMap.put(
                nums[index + k - 1], sortedFrequencyMap.getOrDefault(nums[index + k - 1], 0) + 1);
            result[index] = sortedFrequencyMap.lastKey();
        }

        return result;
    }
}
