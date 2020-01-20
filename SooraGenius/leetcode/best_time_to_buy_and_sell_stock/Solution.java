class Solution {
    public int maxProfit(int[] prices) {
        int benefit = 0;
        for(int i = 0; i<prices.length; i++) {
            for(int j = i + 1; j<prices.length; j++) {
                if(prices[i] < prices[j]) {
                    benefit = Integer.max(prices[j] - prices[i], benefit);
                }
            }
        }
        return benefit;
    }
}