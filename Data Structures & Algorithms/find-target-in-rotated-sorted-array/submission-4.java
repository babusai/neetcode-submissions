class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int start = 0;
        int end = nums.length - 1;

        int mid = start + (end - start) / 2;

        if (nums[start] <= nums[mid] && nums[mid] <= nums[end]) {
            return binarySearch(nums, target, start, end);
        }

        do {
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                System.out.println(":"+ mid + ":" + start + ":" + end);
                int first = binarySearch(nums, target, 0, mid);
                if (first != -1) {
                    return first;
                } else {
                    return binarySearch(nums, target, mid + 1, nums.length - 1);
                }
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                System.out.println("{}"+ mid + "{}" + start + "{}" + end);
                int first = binarySearch(nums, target, 0, mid - 1);
                if (first != -1) {
                    return first;
                } else {
                    return binarySearch(nums, target, mid, nums.length - 1);
                }
            }

            if (nums[start] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        } while (start <= end);

        return -1;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        int mid;

        do {
            mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        } while (start <= end && nums[mid] != target);

        return nums[mid] == target ? mid : -1;
    }
}
