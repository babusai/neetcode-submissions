class Solution {
    
    List<List<Integer>> subsetsWithDup = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        subsetsWithDup(nums, 0, visited, new ArrayList<>());
        return subsetsWithDup;
    }

    private void subsetsWithDup(int[] nums, int index, boolean[] visited, List<Integer> current) {

        if(index == nums.length) {
            subsetsWithDup.add(new ArrayList<>(current));
            return;
        }

        if(index == 0 || nums[index - 1] != nums[index] || visited[index - 1]) {
            current.add(nums[index]);
            visited[index] = true;
            subsetsWithDup(nums, index + 1, visited, current);
            current.removeLast();
            visited[index] = false;
        }

        subsetsWithDup(nums, index + 1, visited, current);
    }


}
