class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> monotonicStack = new ArrayDeque<>();
        int[] answers = new int[heights.length];
        for (int index = heights.length - 1; index >= 0; index--) {
            while (!monotonicStack.isEmpty() && heights[monotonicStack.peek()] >= heights[index]) {
                monotonicStack.pop();
            }

            if (monotonicStack.isEmpty()) {
                answers[index] = heights.length;
            } else {
                answers[index] = monotonicStack.peek();
            }

            monotonicStack.push(index);
        }

        monotonicStack.clear();
        int answer = 0;
        for (int index = 0; index < heights.length; index++) {
            while (!monotonicStack.isEmpty() && heights[monotonicStack.peek()] >= heights[index]) {
                monotonicStack.pop();
            }

            if (monotonicStack.isEmpty()) {
                answers[index] = answers[index] * heights[index];
            } else {
                answers[index] =
                    (answers[index] - 1 - (monotonicStack.peek() + 1) + 1) * heights[index];
            }
            answer = Math.max(answer, answers[index]);
            monotonicStack.push(index);
        }
        return answer;
    }
}
