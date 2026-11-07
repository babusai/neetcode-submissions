class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int back = numbers.length - 1;

        int sum;
        do {
            sum = numbers[front] + numbers[back];

            if (sum < target) {
                front++;
            } else if (sum > target) {
                back--;
            }
        } while (sum != target);

        return new int[] {front + 1, back + 1};
    }
}
