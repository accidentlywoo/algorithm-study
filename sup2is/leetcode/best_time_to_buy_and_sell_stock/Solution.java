package best_time_to_buy_and_sell_stock;

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 0) {
            return 0;
        }

        int[] ans = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            for (int j = i; j >= 0; j--) {
                if(prices[i] > prices[j] && ans[i] < prices[i] - prices[j]) {
                    ans[i] = prices[i] - prices[j];
                }
            }
        }

        return Arrays.stream(ans)
                .max()
                .getAsInt();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[] {7,6,4,3,1}));
    }
}