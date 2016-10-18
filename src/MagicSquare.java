import java.util.Scanner;

public class MagicSquare {
//
//	public static void main(String[] args) {
//
////		String line1 = "4 9 2";
////		String line2 = "3 5 7";
////		String line3 = "8 1 5";
//		
////		Scanner in = new Scanner(System.in);
////
////		int[][] matrix = new int[3][3];
////		for (int i = 0; i < 3; i++) {
////			String line = in.nextLine();
////			String[] temp = line.split(" ");
//////			System.out.println(line);
////			for (int j = 0; j < 3; j++) {
//////				System.out.println(temp[j]);
////				matrix[i][j] = Integer.parseInt(temp[j]);
////			}
////		}
//		
//		int matrix[][] = {
//				          {4, 9, 2},
//				          {3, 5, 7},
//				          {8, 1, 5}
//						 };
//
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println("");
//		}
//		
//		if (checkSums(matrix)) {
//			// Already perfect
//			System.out.println("0");
//			return;
//		}
//		
//		while(!checkSums(matrix)) {
//			checkMatrix(matrix);
//		}
//	}
//	
//	
//	private static void checkMatrix(int[][] square) {
//		int corruptedRow = checkRow(square);
//		if (corruptedRow == -1) {
//			return;
//		} else {
//			
//		}
//	}
//	
//	private static void updateByColumn(int[][] square, int rowNo) {
//		// Check each column.
//        for (int j = 0; j < 3; j++)
//        {
//            // Find the sum of column #j.
//            int sum = 0;
//                sum += square[rowNo][j];
//
//            // If this column does not equal 15, then it is not a magic square
//            if (sum != 15)
//                return false;
//        }
//	}
//	
//	private static int checkRow(int[][] square) {
//		// Check each row.
//        for (int i = 0; i < 3; i++)
//        {
//            // Find the sum of row #i.
//            int sum = 0;
//            for (int j = 0; j < 3; j++)
//                sum += square[i][j];
//
//            // If this row does not equal 15, then it is not a magic square
//            if (sum != 15)
//                return i;
//        }
//        return -1;
//	}
//	
//	/* checkSums:
//     * Check that the sum of the rows, columns and diagonals all equal 15.
//     * 
//     * returns: true is all rows, columns and diagonals equal 15, false otherwise.
//     */
//    private static boolean checkSums(int[][] square)
//    {
//        // Check each row.
//        for (int i = 0; i < 3; i++)
//        {
//            // Find the sum of row #i.
//            int sum = 0;
//            for (int j = 0; j < 3; j++)
//                sum += square[i][j];
//
//            // If this row does not equal 15, then it is not a magic square
//            if (sum != 15)
//                return false;
//        }
//
//        // Check each column.
//        for (int j = 0; j < 3; j++)
//        {
//            // Find the sum of column #j.
//            int sum = 0;
//            for (int i = 0; i < 3; i++)
//                sum += square[i][j];
//
//            // If this column does not equal 15, then it is not a magic square
//            if (sum != 15)
//                return false;
//        }
//
//        // Check forward diagonal.
//        if (square[0][0] + square[1][1] + square[2][2] != 15)
//            return false;
//
//        // Check backward diagonal.
//        if (square[0][2] + square[1][1] + square[2][0] != 15)
//            return false;
//
//        return true;
//    }
//    
//    /* checkFrequency:
//     * Make sure that each number 1 through 9 is in the square exactly once.
//     * 
//     * returns: true if each number (1-9) appears exactly once, false otherwise.
//     */
//    private static void checkFrequency(int[][] square)
//    {
//        // Create an array to store the number of times each number appears.
//        int[] freq = new int[10];
//
//        // Set each frequency to zero initially.
//        // Note: We will NOT use index 0 and we will store how many 1s we see
//        //       in index 1, etc.
//        for (int i = 1; i < 10; i++)
//            freq[i] = 0;
//
//        // Loop through each value in the square.
//        for (int i = 0; i < 3; i++)
//        {
//            for (int j = 0; j < 3; j++)
//            {
//                // Invalid number - all values must be between 1 - 9.
//                if (square[i][j] < 1 || square[i][j] > 9) {
//                	freq[square[i][j]] = -1;
//                } else {
//                	// Increase the frequncy for this number.
//                    freq[square[i][j]]++;
//                }
//
//                
//            }
//        }
//
//        // If any number does not appear exactly once then the square is not magic.
//        for (int i = 1; i < 10; i++)
//            if (freq[i] != 1) {
//            	
//            }
//                return false;
//
//        return true;
//    }
}
