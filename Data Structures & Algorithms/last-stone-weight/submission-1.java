class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        int first;
        int second;
        while (!maxHeap.isEmpty() && maxHeap.size() != 1) {
            first = maxHeap.poll();
            second = maxHeap.poll();
            maxHeap.offer(first - second);
            // if (first > second) {
            //     maxHeap.offer(first - second);
            // } else if (first < second) {
            //     maxHeap.offer(second - first);
            // }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
