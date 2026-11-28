class Solution {
    private List<List<Integer>> permutations;

    public List<List<Integer>> permute(int[] nums) {
        permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, visited, new ArrayList<>());
        return permutations;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> current) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int index = 0; index < nums.length; index++) {
            if (!visited[index]) {
                current.add(nums[index]);
                visited[index] = true;
                permute(nums, visited, current);
                current.removeLast();
                visited[index] = false;
            }
        }
    }
}
