package sudoku;

public class Sudoku {

	/**
	 * @param args
	 */
   public static boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
	   for(int i=0;i<9;i++){
		   boolean[] line = new boolean[9]; 
	       boolean[] col = new boolean[9];
        	for(int j=0;j<9;j++){
        		if(board[i][j]!='.'){
        		int value = board[i][j]-48;
        		if(line[value-1]) return false;
        		line[value-1]=true;}
        		//for column
        		if(board[j][i]!='.'){
        		int value1 = board[j][i]-48;
        		if(col[value1-1]) return false;
        		col[value1-1]=true;}
        	}
        }
	   int[] is = new int[]{0,3,6};
	   int[] js = new int[]{0,3,6};
	   for(int m:is){
		   for(int n:js){
			   int end_i = m+3;
			   int end_j = n+3;
			   boolean[] box = new boolean[9];
			   for(int i=m;i<end_i;i++){
				   for(int j=n;j<end_j;j++){
					   if(board[i][j]=='.'){
		        			continue;
		        		}
					  int value = board[i][j]-48;
		        	  if(box[value-1]) return false;
		        	  box[value-1]=true;
				   }
			   }
		   }
	   }
	   return true;
    }
   public static char[][] init(String[] s){
	   char[][] board = new char[9][9];
	   for(int i=0;i<s.length;i++){
		   String str = s[i];
		   for(int j=0;j<str.length();j++){
			   board[i][j]=str.charAt(j);
		   }
	   }
	   return board;
   }
   public static void p(Object o){
		System.out.print(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[9][9];
		String[] s = new String[]{"4........",".........",".........","4........",".........",".........",".........",".........","........."};
		board = init(s);
		p(isValidSudoku(board));
//		int[] a = new int[]{0,3,6};
//		for(int i:a){
//			p(i);
//		}
	}

}
