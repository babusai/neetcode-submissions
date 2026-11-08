class Solution {
    public int maxProfit(int[] prices) {
        int minIndex = 0;
        int maxProfit = 0;
        int index;
        for (index = 1; index < prices.length; index++) {
            if (prices[index] < prices[index - 1]) {
                maxProfit = Math.max(maxProfit, prices[index - 1] - prices[minIndex]);
                if (prices[index] < prices[minIndex]) {
                    minIndex = index;
                }
            }
        }

        return Math.max(maxProfit, prices[index - 1] - prices[minIndex]);
    }
}
