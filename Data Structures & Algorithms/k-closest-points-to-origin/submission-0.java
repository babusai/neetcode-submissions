class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<Map.Entry<Integer, Double>> comparator =
            (a, b) -> a.getValue() > b.getValue() ? -1 : 1;
        Queue<Map.Entry<Integer, Double>> maxHeap = new PriorityQueue<>(comparator);
        for (int index = 0; index < points.length; index++) {
            maxHeap.offer(new AbstractMap.SimpleEntry<>(
                index, Math.sqrt(Math.pow(points[index][0], 2) + Math.pow(points[index][1], 2))));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] kClosest = new int[k][2];
        int index = 0;
        Map.Entry<Integer, Double> entry;

        while (index < k) {
            entry = maxHeap.poll();
            kClosest[index++] = points[entry.getKey()];
        }

        return kClosest;
    }
}
