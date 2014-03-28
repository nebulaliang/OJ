package removeElement;

import java.util.Arrays;

public class RemoveElement {

	/**
	 * @param args
	 */
	public static int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int n = A.length;
		if(n==0) return 0;
		Arrays.sort(A);
		int first=-1;
		int end=-1;
		for(int i=0;i<n;i++){
			if(A[i]==elem){
				first = i;
				break;
			}
		}
		if(first==-1) return n;
		if(first==n-1){ end=n-1;}
		else{
		for(int i=first+1;i<n;i++){
			if(A[i]!=elem){
				end = i-1;
				break;
			}
			if(i==n-1) end=n-1;
		}
		
		}
		int len = end-first+1;
		for(int i=end+1;i<n;i++){
			int j = i-len;
			A[j]=A[i];
		}
		int result = n-len;
		A = Arrays.copyOfRange(A, 0, result);
		return result;
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{2,2,2};
		p(removeElement(num,2));
	}

}
