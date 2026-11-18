class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int length = 0;
        do {
            length++;
            slow = nums[slow];
        } while (slow != fast);

        int first = 0;
        do {
            first = nums[first];
            length--;
        } while (length != 0);

        int second = 0;
        do {
            first = nums[first];
            second = nums[second];
        } while (first != second);

        return first;
    }
}
