package jump;

public class Jump {

	/**
	 * @param args
	 */
	public boolean canJump(int[] A) {
		// i is cursor for traverse;j is the current farthest distance
        int j=0;
        for(int i=0;i<A.length;i++){
        	//when i>j, it means the farthest distance is to j. 
        	//It doesn't need to go through the remain elements.
        	if(i<=j && A[i]+i>j) j=A[i]+i;
        	if(i>j) break;
        	//Also, if j over the last element of A, we can safely return true.
        	if(j>=A.length-1) return true;
        }
        return j>=A.length-1;
    }
//	public static int jump1(int[] A) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//		//This is the O(n^2) method
//		if(A.length==1) return 0;
//		int[] a = new int[A.length];
//		for(int i=A.length-2;i>=0;i--){
//			if(A[i]+i>=A.length-1){
//				a[i]=1;
//			}
//			else{
//				int step = A[i];
//				int min = a[i+1];
//				if(step>=2){
//				for(int j=2;j<step;j++){
//					if(a[i+j]!=0)
//					min = a[j]<min?a[j]:min;
//				}}
//				a[i]=min==0?0:min+1;
//			}
//		}
//        return a[0];
//    }
	
	//leetcode Jump Game II 
	public static int jump(int[] A) {
		//This is the O(n^2) method
		if(A.length==1) return 0;
		int max = A[0];
		int step = 0;//if it is initialed as 1, at end we would return step.
		int i = 1;
		while(max<A.length-1){
			int m = max;
			for(;i<=max;i++){
				//m = A[i]+i>m?A[i]+i:m;
				m = Math.max(m, A[i]+i);
			}
			max = m;
			step++;
		}
		return step+1;
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[]{5,4,3,2,1};
		int b=jump(A);
		p(b);
	}

}
