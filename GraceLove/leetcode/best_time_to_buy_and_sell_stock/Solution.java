package leetcode.best_time_to_buy_and_sell_stock;

public class Solution {

    public int maxProfit(int[] prices) {
        int bestPrice = 0;

        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                if(bestPrice < prices[j] - prices[i]) {
                    bestPrice = prices[j] - prices[i];
                }
            }
        }

        return bestPrice;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
