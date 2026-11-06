class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        
        for(int i = 0; i < nums.length && numsSet.size() == i; i++) {
            numsSet.add(nums[i]);
        }

        return numsSet.size() != nums.length;
    }
}