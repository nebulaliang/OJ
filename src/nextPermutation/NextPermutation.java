package nextPermutation;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        int i = n-1;
        int j = n-2;
        while(j>=0){
        	if(num[j]>=num[i]){
        		i--;j--;
        		continue;
        	}
        	break;
        }
        int x = i;
        int y = n-1;
        while(x<=(x+y)/2){
        	int temp = num[x];
        	num[x] = num[y];
        	num[y] = temp;
        	x++;y--;
        }
        if(i!=0){
        	while(i<n){
        		if(num[j]>=num[i]){
        			i++;
        		}
        		else{
        			int temp = num[j];
        			num[j] = num[i];
        			num[i] = temp;
        			break;
        		}
        	}
        }
    }
	//solution for Permutation Sequence(leetcode 68)
	public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int result[] = new int[n];
		for(int i=0;i<n;i++){
        	result[i]=i+1;
        }
		for(int i=1;i<k;i++){
			result = getnext(result);
		}
		return array2String(result);
    }
	//solution for Permutations(leetcode 69)
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n = num.length;
        int k = n-1;
        int time = n;
        while(k>1){
        	time*=k;
        	k--;
        }
        ArrayList<Integer> list = array2list(num);
        result.add(list);
        for(int j=1;j<time;j++){
        	int[] temp = getnext(num);
        	result.add(array2list(temp));
        	num = temp;
        }
        return result;
    }
	//solution for Permutations II(leetcode 70)
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n = num.length;
        int k = n-1;
        int time = n;
        while(k>1){
        	time*=k;
        	k--;
        }
        int[] first = num;
        ArrayList<Integer> list = array2list(num);
        result.add(list);
        for(int j=1;j<time;j++){
        	int[] temp = getnext(num);
        	if(arrayEquals(temp,first)) break;
        	result.add(array2list(temp));
        	num = temp;
        }
        return result;
    }
	public static boolean arrayEquals(int[] o1,int[] o2) {
		if(o1.length != o2.length) return false;
		for(int i = 0;i<o1.length;i++){
			if(o1[i]!=(o2[i])) return false;			
		}
		return true;
	}
	public static ArrayList<Integer> array2list(int[] num){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<num.length;i++){
			result.add(new Integer(num[i]));
		}
		return result;
	}
	public static int[] getnext(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        int result[] = new int[n];
        for(int k=0;k<n;k++){
        	result[k]=num[k];
        }
        int i = n-1;
        int j = n-2;
        while(j>=0){
        	if(result[j]>=result[i]){
        		i--;j--;
        		continue;
        	}
        	break;
        }
        int x = i;
        int y = n-1;
        while(x<=(x+y)/2){
        	int temp = result[x];
        	result[x] = result[y];
        	result[y] = temp;
        	x++;y--;
        }
        if(i!=0){
        	while(i<n){
        		if(result[j]>=result[i]){
        			i++;
        		}
        		else{
        			int temp = result[j];
        			result[j] = result[i];
        			result[i] = temp;
        			break;
        		}
        	}
        }
        return result;
    }
	public static String array2String(int[] num){
		StringBuffer result = new StringBuffer();
		for(int i=0;i<num.length;i++){
			int value = num[i];
			result.append(value);
		}
		return result.toString();
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{1,2,3};
		p(array2String(getnext(num)));
	}

}
