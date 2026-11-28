class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, new ArrayList<>());
    }

    private List<List<Integer>> subsets(int[] nums, int index, List<Integer> subset) {
        if (index == nums.length) {
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(new ArrayList<>(subset));
            return subsets;
        }

        List<List<Integer>> result = new ArrayList<>();

        subset.add(nums[index]);
        List<List<Integer>> taken = subsets(nums, index + 1, subset);
        subset.removeLast();

        List<List<Integer>> notTaken = subsets(nums, index + 1, subset);

        result.addAll(taken);
        result.addAll(notTaken);

        return result;
    }
}
