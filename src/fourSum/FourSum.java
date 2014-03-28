package fourSum;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

	/**
	 * @param args
	 */
	public static void p(Object o){
		System.out.println(o);
	}
	
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num,int target) {
		int n = num.length;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n<4){
			return result;
		}
        Arrays.sort(num);
        int mark = num[0]-1;
        for(int i=0;i<n-3;i++){
        	int first = num[i];
        	if(mark==first){continue;}
        	int mark_second = num[0]-1;
        	for(int m=i+1;m<n-2;m++){
        		int second = num[m];
        		if(mark_second==second){continue;}
        		int require = target-first-second;
            	int j = m+1;
            	int k = n-1;
            	int mark_j = num[0]-1;
    			int mark_k = num[0]-1;
            	while(j<k){
            		if(num[j]+num[k]>require){
            			k--;
            		}
            		else if(num[j]+num[k]<require){
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
            			temp.add(new Integer(num[m]));
            			temp.add(new Integer(num[j]));
            			temp.add(new Integer(num[k]));
            			result.add(temp);
            			mark_j=num[j];
            			mark_k=num[k];
            			j++;
            			k--;
            			mark = first;
            			mark_second = second;
            		}
            	}
        	}
        	
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-3,-2,-1,0,0,1,2,3};
		ArrayList<ArrayList<Integer>> result = fourSum(num,0);
		for(ArrayList<Integer> i:result){
			for(Integer n:i ){
				System.out.print(n);System.out.print(" ");
			}
			p("");
		}
	}

}
