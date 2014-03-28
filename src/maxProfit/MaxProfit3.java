package maxProfit;

public class MaxProfit3 {

	/**
	 * @param args
	 */
	public static void p(Object o){
		System.out.println(o);
	}
	public static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int result = 0;
		int n = prices.length;
        if(n<2) return 0;
        int[] leftprofit = new int[n];
        int[] rightprofit = new int[n];
        leftprofit[0] = 0;
        int small = prices[0];
        for(int i=1;i<n;i++){
        	int num = prices[i];
        	if(num<small){
        		small = num;
        		leftprofit[i]=leftprofit[i-1];
        	}
        	else{
        		int diff = num-small;
        		if(diff>leftprofit[i-1]) leftprofit[i] = diff;
        	}
        }
        rightprofit[n-1] = 0;
        small = prices[n-1];
        int largeIndex = n-1;
        for(int j=n-2;j>=0;j--){
        	int num = prices[j];
        	if(num>prices[largeIndex]) largeIndex = j;
        	rightprofit[j] = Math.max(prices[largeIndex]-prices[j], rightprofit[j+1]);
        	if(leftprofit[j]+rightprofit[j]>result) result = leftprofit[j]+rightprofit[j];
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,4,2,5,7,2,4,9,0,9};
		p(maxProfit(a));
	}

}
