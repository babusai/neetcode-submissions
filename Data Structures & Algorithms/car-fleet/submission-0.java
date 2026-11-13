class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> sorted = new TreeMap<>(Comparator.reverseOrder());
        for (int index = 0; index < position.length; index++) {
            sorted.put(position[index], (double) speed[index]);
        }
        Stack<Double> fleets = new Stack<>();

        double time;
        for (Map.Entry<Integer, Double> entry : sorted.entrySet()) {
            time = (target - entry.getKey()) / entry.getValue();
            if (fleets.isEmpty() || time > fleets.peek()) {
                fleets.push(time);
            }
        }
        return fleets.size();
    }
}
