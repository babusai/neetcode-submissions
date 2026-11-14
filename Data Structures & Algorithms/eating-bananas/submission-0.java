class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end = 0;
        for (int pile : piles) {
            end = Math.max(end, pile);
        }
        int start = 1;

        int mid;
        int hours;
        while (start <= end) {
            mid = start + (end - start) / 2;
            hours = 0;
            for (int pile : piles) {
                hours = hours + (pile / mid + (pile % mid == 0 ? 0 : 1));
                if (hours > h) {
                    start = mid + 1;
                    break;
                }
            }
            if (hours <= h) {
                end = mid - 1;
            }
        }

        return start;
    }
}
