class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> entry;
        for (int index = 0; index < nums.length - 2 && nums[index] <= 0; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            int target = nums[index];

            int front = index + 1;
            int back = nums.length - 1;

            int sum;

            while (front < back) {
                sum = nums[front] + nums[back] + nums[index];

                if (sum > 0) {
                    back--;
                } else if (sum < 0) {
                    front++;
                } else {
                    entry = new ArrayList<>();
                    entry.add(nums[index]);
                    entry.add(nums[front]);
                    entry.add(nums[back]);
                    result.add(entry);

                    front++;
                    back--;

                    while (front < back && nums[front] == nums[front - 1]) {
                        front++;
                    }
                }
            }
        }

        return result;
    }
}
