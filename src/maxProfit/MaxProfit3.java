package maxProfit;

public class MaxProfit3 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int min = prices[0];
        int[] left_maxProfit = new int[len];
        //compute the left profit. Store each value at left_maxProfit
        for (int i = 1; i < len; i++) {
            left_maxProfit[i] = Math.max(left_maxProfit[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        //compute the right profit.
        int max = prices[len - 1];
        int right_maxProfit = 0;
        int total_profit = left_maxProfit[len - 1];
        
        for (int i = len - 2; i >= 0; i--) {
            right_maxProfit = Math.max(right_maxProfit, max - prices[i]);
            max = Math.max(max, prices[i]);
            total_profit = Math.max(total_profit, left_maxProfit[i] + right_maxProfit);
        }
        
        return total_profit;
    }

}
