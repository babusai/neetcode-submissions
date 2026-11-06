class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexToValueMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(indexToValueMap.get(target - nums[i]) != null) {
                return new int[]{indexToValueMap.get(target - nums[i]),i};
            }
            indexToValueMap.put(nums[i], i);
        }
          return null;
    }

}
