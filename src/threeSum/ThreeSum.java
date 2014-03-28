package threeSum;
import java.util.ArrayList;
import java.util.Arrays;


public class ThreeSum {

	/**
	 * @param args
	 */
	public static void p(Object o){
		System.out.println(o);
	}
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		int n = num.length;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n<3){
			return result;
		}
        Arrays.sort(num);
        int mark = num[0]-1;
        for(int i=0;i<n;i++){
        	int first = num[i];
        	if(mark==first){continue;}
        	int target = 0-first;
        	int j = i+1;
        	int k = n-1;
        	int mark_j = num[0]-1;
			int mark_k = num[0]-1;
        	while(j<k){
        		if(num[j]+num[k]>target){
        			k--;
        		}
        		else if(num[j]+num[k]<target){
        			j++;
        		}
        		else{
        			if(mark_j==num[j] && j<k){
        				j++;
        				continue;
        			}
        			if(mark_k==num[k] && j<k){
        				k--;
        				continue;
        			}
        			ArrayList<Integer> temp = new ArrayList<Integer>();
        			temp.add(new Integer(num[i]));
        			temp.add(new Integer(num[j]));
        			temp.add(new Integer(num[k]));
        			result.add(temp);
        			mark_j=num[j];
        			mark_k=num[k];
        			j++;
        			k--;
        			mark = first;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0,0,0,0};
		ArrayList<ArrayList<Integer>> result = threeSum(num);
		for(ArrayList<Integer> i:result){
			
			for(Integer n:i ){
				System.out.print(n);System.out.print(" ");
			}
			p("");
		}
	}

}
