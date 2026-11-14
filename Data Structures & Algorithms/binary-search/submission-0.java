class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int mid;
        do {
            mid = start + (end - start)/2;

            if(nums[mid] > target) {
                end = mid - 1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } 
        } while(start <= end && nums[mid] != target);

        return start > end ? -1 : mid;
    }
}
