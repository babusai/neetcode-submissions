class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        while (!set.isEmpty()) {
            int length = 1;
            Integer curr = set.iterator().next();
            set.remove(curr);

            int left = curr - 1;
            while (set.contains(left)) {
                set.remove(left);
                length++;
                left -= 1;
            }

            int right = curr + 1;
            while (set.contains(right)) {
                set.remove(right);
                length++;
                right += 1;
            }

            max = Math.max(max, length);
        }

        return max;
    }
}
