class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.putIfAbsent(num, 0);
            frequency.put(num, frequency.get(num) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length];

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (buckets[entry.getValue() - 1] == null) {
                buckets[entry.getValue() - 1] = new ArrayList<Integer>();
            }
            buckets[entry.getValue() - 1].add(entry.getKey());
        }

        int[] answer = new int[k];

        int i = 0;
        for (int index = nums.length - 1; index >= 0; index--) {
            if (buckets[index] != null) {
                for (Integer elem : buckets[index]) {
                    answer[i++] = elem;
                    if (i == k) {
                        return answer;
                    }
                }
            }
        }

        return null;
    }
}
