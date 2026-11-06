class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1,  2,  8,  48
        // 48, 48, 24, 6

        // 1, 2, 4, 6

        int[] productFromFront = new int[nums.length];
        int[] productFromBack = new int[nums.length];

        int product = 1;

        for (int index = 0; index < nums.length && nums[index] != 0; index++) {
            product *= nums[index];
            productFromFront[index] = product;
        }

        product = 1;
        for (int index = nums.length - 1; index >= 0 && nums[index] != 0; index--) {
            product *= nums[index];
            productFromBack[index] = product;
        }

        int[] output = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {
            if (index == 0) {
                output[index] = productFromBack[index + 1];
            } else if (index == nums.length - 1) {
                output[index] = productFromFront[index - 1];
            } else {
                output[index] = productFromFront[index - 1] * productFromBack[index + 1];
            }
        }

        return output;
    }
}
