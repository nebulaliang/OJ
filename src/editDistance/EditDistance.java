package editDistance;

public class EditDistance {

	/**
	 * @param args
	 */
	//MEDIUM HARD
	//use DP
	 public static int minDistance(String word1, String word2) {
		 if(word1.equals("") || word2.equals("")) return Math.max(word1.length(), word2.length());
		 char[] from = word1.toCharArray();
		 char[] to = word2.toCharArray();
		 int[][] M = new int[to.length][from.length];
		 //init first element
		 //if the first letter doesn't equal, the edit distance for the first letters is 1
		 if(to[0]!=from[0]) M[0][0]=1;
		 //init first column
		 //the col_dulplicate is used for record whether there exist same letter
		 //the same letter only has one chance to reduce edit distance
		 boolean col_dulplicate = false;
		 for(int i=1;i<to.length;i++){
			 if(to[i]==from[0] && !col_dulplicate){
				 M[i][0]=M[i-1][0];
				 col_dulplicate = true;
			 }
			 else{
				 M[i][0]=M[i-1][0]+1;
			 }
		 }
		 //init first line
		 //line_dulplicate is similar with col_dulplicate descripted as above 
		 boolean line_dulplicate = false;
		 for(int j=1;j<from.length;j++){
			 if(from[j]==to[0] && !line_dulplicate){
				 M[0][j]=M[0][j-1];
				 line_dulplicate = true;
			 }
			 else{
				 M[0][j]=M[0][j-1]+1;
			 }
		 }
		 for(int i=1;i<to.length;i++){
			 for(int j=1;j<from.length;j++){
				 //if the letter for comparing are same, use edit distance from up left
				 if(from[j]==to[i]){
					 M[i][j]=M[i-1][j-1];
				 }
				 //otherwise, choose the minimal one from up,left,upleft, and add one
				 else{
					 M[i][j]=Math.min(M[i][j-1], Math.min(M[i-1][j-1], M[i-1][j]))+1;
				 }
			 }
		 }
	        return  M[to.length-1][from.length-1];
	    }
	 public static void p(Object o){
			System.out.println(o);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopic"));
	}

}
