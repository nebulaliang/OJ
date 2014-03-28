package removeDuplicates;

import java.util.Arrays;

public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if(n==0) return 0;
        int i = 0;
        int j = 1;
        int current = A[0];
        while(j<n){
        	if(A[j]==current){
        		j++;
        	}
        	else{
        		i++;
        		//A[i]=A[j];
        		current = A[j];
        	}
        }
        return i+1;
    }
	//This allows a element twice
	public static int removeDuplicates1(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int n = A.length;
        if(n==0) return 0;
        int i = 0;
        int j = 1;
        int current = A[0];
        boolean dup = false;
        while(j<n){
        	if(A[j]==current){
        		if(!dup){
        			i++;
            		A[i]=A[j];
            		dup=true;
        		}
        	}
        	else{
        		i++;
        		A[i]=A[j];
        		current = A[j];
        		dup=false;
        	}
        	j++;
        }
        return i+1;
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{1,1,2,2,3};
		p(removeDuplicates1(num));
	}

}
