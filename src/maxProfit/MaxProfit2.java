package maxProfit;

public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int take = prices[0];
        int result = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] > take) {
                result += prices[i] - take;
            }
            take = prices[i];    
        } 
        
        return result;
    }

}
