package candy;

import java.util.Arrays;

public class Candy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,2,3,4,1};
		p(candy(a));
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static int candy(int[] ratings) {
        int len = ratings.length;
        if(len==1) return 1;
        if(len==2) return ratings[0]==ratings[1]?2:3;
        int[] candys = new int[len];
        Arrays.fill(candys,1);
        //idea: go through the array two times.
        //First time, from left to right; second time, from right to left.
        int current = ratings[0];
        int next;
        for(int i=1;i<len;i++){
        	next = ratings[i];
        	if(next>current)
        		candys[i] = candys[i-1]+1;
        	current = ratings[i];
        }
        current = ratings[len-1];
        for(int i=len-2;i>=0;i--){
        	next = ratings[i];
        	if(next>current && candys[i]<=candys[i+1])
        		candys[i] = candys[i+1]+1;
        	current = ratings[i];
        }
        int result = 0;
        for(int val:candys){
        	result+=val;
        }
        return result;
    }
}
