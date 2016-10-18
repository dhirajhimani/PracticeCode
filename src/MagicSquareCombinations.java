
public class MagicSquareCombinations {
	
	private static int[][] defaultMatrix = {
									          {4, 9, 2},
									          {3, 5, 7},
									          {8, 1, 5}
											};
	
	
	public static void main(String[] args) {
		//There are 8 combinations for 3x3 matrix
		int[][][] matrixCombinations = new int[8][3][3];
		int[][] tempMatrix = new int[3][3];
		
		matrixCombinations[0] = defaultMatrix;
		matrixCombinations[1] = getVerticallyFlippedMatrix(defaultMatrix);
//		print(matrixCombinations[1]);
		matrixCombinations[2] = getHorizontallyFlippedMatrix(defaultMatrix);
		matrixCombinations[3] = getHorizontallyFlippedMatrix(matrixCombinations[1]);
		matrixCombinations[4] = getTranslatedMatrix(matrixCombinations[0]);
		matrixCombinations[5] = getTranslatedMatrix(matrixCombinations[1]);
		matrixCombinations[6] = getTranslatedMatrix(matrixCombinations[2]);
		matrixCombinations[7] = getTranslatedMatrix(matrixCombinations[3]);
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					System.out.print(matrixCombinations[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println("\n");
		}
	}
	
	private static void print(int[][] defaultMatrix2){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
					System.out.print(defaultMatrix2[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("\n");
	}
	
	private static int[][] getTranslatedMatrix(int[][] defaultMatrix2) {
		int[][] tempMatrix = new int[3][3];
		for (int i = 0; i < tempMatrix.length; i++) {
			for (int j = 0; j < tempMatrix.length; j++) {
				tempMatrix[i][j] = defaultMatrix2[j][i];
			}
		}
		
		return tempMatrix;
	}


	private static int[][] getHorizontallyFlippedMatrix(int[][] defaultMatrix2) {
		int[][] tempMatrix = new int[3][3];
		for (int i = 0; i < 3; i++) {
			tempMatrix[1][i] = defaultMatrix2[1][i];
			int sum = defaultMatrix2[0][i] + defaultMatrix2[2][i];
			tempMatrix[0][i] = sum - defaultMatrix2[0][i];
			tempMatrix[2][i] = sum - defaultMatrix2[2][i];
			
		}
		return tempMatrix;
	}


	private static int[][] getVerticallyFlippedMatrix(int[][] defaultMatrix2) {
		int[][] tempMatrix = new int[3][3];
		for (int i = 0; i < 3; i++) {
			tempMatrix[i][1] = defaultMatrix2[i][1];
			int sum = defaultMatrix2[i][0] + defaultMatrix2[i][2];
			tempMatrix[i][0] = sum - defaultMatrix2[i][0];
			tempMatrix[i][2] = sum - defaultMatrix2[i][2];
			
		}
		return tempMatrix;
	}
}
