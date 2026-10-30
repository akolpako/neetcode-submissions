class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 100;
        int profit = 0;

        for (int nextPrice : prices) {
            if (nextPrice < minPrice) {
                minPrice = nextPrice;
            } else {
                profit = Math.max(profit, nextPrice - minPrice);
            }
        }
        return profit;
    }
}
