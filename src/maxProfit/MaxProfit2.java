package maxProfit;

public class MaxProfit2 {

	/**
	 * @param args
	 */
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        if(prices.length<2) return 0;
        int i = 0;
        int j = 1;
        for(;i<prices.length-1;i++){
        	if(prices[j]>prices[i]) {
        		result+=prices[j]-prices[i];}
        		j++;
        }
        return result; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
