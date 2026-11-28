class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] nums, int target, int beginIndex, 
        List<Integer> current, List<List<Integer>> result) {

        // if(beginIndex == nums.length) {
        //     return;
        // }

        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }    

        for(int index = beginIndex; index < nums.length; index++){
            if(nums[index] <= target) {
                current.add(nums[index]);
                combinationSum(nums, target - nums[index], index, current, result);
                current.removeLast();
            }
        }
        
    }
}
