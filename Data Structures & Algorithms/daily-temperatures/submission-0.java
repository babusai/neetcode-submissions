class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> monotonicStack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int index = temperatures.length - 1; index >= 0; index--) {
            while (!monotonicStack.isEmpty()
                && temperatures[monotonicStack.peek()] <= temperatures[index]) {
                monotonicStack.pop();
            }

            if (!monotonicStack.isEmpty()) {
                result[index] = monotonicStack.peek() - index;
            }

            monotonicStack.push(index);
        }
        return result;
    }
}
