class Solution {

    private List<List<Integer>> combinationSum2; 
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2 = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        combinationSum2(candidates, target, 0, visited, new ArrayList<>());
        return combinationSum2;
    }

    private void combinationSum2(int[] candidates, int target, int beginIndex,boolean[] visited, List<Integer> current) {
        if(target == 0) {
            combinationSum2.add(new ArrayList<>(current));
            return;
        }

        for(int index = beginIndex; index < candidates.length; index++) {
            if(visited[index]) {
                continue;
            }

            if(index > 0 && candidates[index] == candidates[index - 1] && !visited[index - 1]) {
                continue;
            }

            if(candidates[index] <= target) {
                current.add(candidates[index]);
                visited[index] = true;
                combinationSum2(candidates, target - candidates[index], index + 1, visited, current);
                current.removeLast();
                visited[index] = false;
            }
        }

    }
}
