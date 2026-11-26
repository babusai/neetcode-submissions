class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer[]> frequency = new HashMap<>();
        for(Character letter: tasks) {
            if(frequency.containsKey(letter)) {
                frequency.get(letter)[0]++;
            } else {
                frequency.put(letter, new Integer[]{1, null});
            }
        }

        Comparator<Map.Entry<Character,Integer[]>> frequencyComparator = (a, b) -> b.getValue()[0].compareTo(a.getValue()[0]);
        Queue<Map.Entry<Character,Integer[]>> maxHeap = new PriorityQueue<>(frequencyComparator);

        for(Map.Entry<Character,Integer[]> entry : frequency.entrySet()) {
            maxHeap.offer(entry);
        }

/*         Queue<Map.Entry<Character,Integer[]>> maxHeapClone = new PriorityQueue<>(maxHeap);
         while(!maxHeapClone.isEmpty()) {
             System.out.println(maxHeapClone.peek().getKey() + " " + Arrays.toString(maxHeapClone.peek().getValue()));
             maxHeapClone.poll();
         }
        System.out.println();*/

        int time = 0;
        Deque<Map.Entry<Character,Integer[]>> queue = new ArrayDeque<>();

        Map.Entry<Character,Integer[]> current = null;

        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
                if(maxHeap.isEmpty()) {
                    current = queue.remove();
                    time = current.getValue()[1];
                    current.getValue()[0]--;
                    if(current.getValue()[0] > 0) {
                        current.getValue()[1] = time + n + 1;
                        queue.offer(current);
                    }
                } else {
                     if(queue.isEmpty() || !queue.getFirst().getValue()[1].equals(time + 1)) {
                        current = maxHeap.poll();
                        time++;
                        current.getValue()[0]--;
                        if(current.getValue()[0] > 0) {
                            current.getValue()[1] = time + n + 1;
                            queue.offer(current);
                        }
                    } else if(queue.getFirst().getValue()[1].equals(time + 1)) {
                        current = queue.remove();
                        time = current.getValue()[1];
                        current.getValue()[0]--;
                        if(current.getValue()[0] > 0) {
                            current.getValue()[1] = time + n + 1;
//                            queue.offer(current);
                            maxHeap.offer(current);
                        }
                    }
                }
//            System.out.println(current.getKey() + " " + Arrays.toString(current.getValue()) + " " + time);
        }

        return time;
    }
}
