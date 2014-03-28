package threeSumClosest;
import java.util.ArrayList;
import java.util.Arrays;


public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void p(Object o){
		System.out.println(o);
	}
	public static int threeSumClosest(int[] num, int target) {
		int n = num.length;
		if(n<3){
			if(n==1) return num[0];
			if(n==2) return num[0]+num[1];
			if(n==3) return num[0]+num[1]+num[2];
		}
		int result = num[0]+num[1]+num[2];
		int diff = Math.abs(result-target);
        Arrays.sort(num);
        for(int i=0;i<n;i++){
        	int first = num[i];
        	int require = target-first;
        	int j = i+1;
        	int k = n-1;
        	while(j<k){
        		int now = num[j]+num[k];
        		if(now>require){
        			if((now-require)<diff){
        				result = now+first;
        				diff = Math.abs(result-target);
        			}
        			k--;
        		}
        		else if(now<require){
        			if((require-now)<diff){
        				result = now+first;
        				diff = Math.abs(result-target);
        			}
        			j++;
        		}
        		else{
        			return target;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
		int result = threeSumClosest(num,18);
		p(result);
	}

}
