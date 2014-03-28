package maxProfit;

public class MaxProfit1 {

	/**
	 * @param args
	 */
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        if(prices.length<2) return result;
        int small = prices[0];
        for(int i=1;i<prices.length;i++){
        	int num = prices[i];
        	if(num<small){
        		small = num;
        	}
        	else{
        		int diff = num-small;
        		if(diff>result) result = diff;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
