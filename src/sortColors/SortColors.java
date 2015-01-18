package sortColors;
import util.MyUtil;
public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyUtil.p("s");
	}

	public void sortColors(int[] A) {
        int n = A.length;
        int low = 0;
        int high = n-1;
        int i = 0;
        while(i<=high){
        	if(A[i]==0){
        		swap(A,low,i);
        		low++;
        		if(i<low)
        			i=low;
        	}
        	else if(A[i]==2){
        		swap(A,high,i);
        		high--;
        	}
        	else{
        		i++;
        	}
        }
    }
	
	public static void swap(int[] A,int i,int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
