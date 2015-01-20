package editDistance;

public class EditDistance {

	public static int minDistance(String word1, String word2) {
		if (word1.equals("") || word2.equals("")) {
			return Math.max(word1.length(), word2.length());
		}

		int len1 = word1.length();
		int len2 = word2.length();

		int[][] matrix = new int[len1][len2];
		// init the first element
		matrix[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
		boolean duplicate = false;
		// init first row
		for (int i = 1; i < len2; i++) {
			if (word1.charAt(0) == word2.charAt(i) && !duplicate) {
				matrix[0][i] = matrix[0][i - 1];
				duplicate = true;
			} else {
				matrix[0][i] = matrix[0][i - 1] + 1;
			}
		}
		// init first column
		duplicate = false;
		for (int i = 1; i < len1; i++) {
			if (word2.charAt(0) == word1.charAt(i) && !duplicate) {
				matrix[i][0] = matrix[i - 1][0];
				duplicate = true;
			} else {
				matrix[i][0] = matrix[i - 1][0] + 1;
			}
		}
		// generate the rest matrix
		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				int min = Math.min(matrix[i - 1][j - 1],
						Math.min(matrix[i][j - 1], matrix[i - 1][j]));
				matrix[i][j] = word1.charAt(i) == word2.charAt(j) ? matrix[i - 1][j - 1]
						: min + 1;
			}
		}

		return matrix[len1 - 1][len2 - 1];
	}

	public static void p(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis",
				"ultramicroscopic"));
	}

}
