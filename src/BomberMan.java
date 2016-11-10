import java.util.Scanner;

//https://www.hackerrank.com/challenges/bomber-man
public class BomberMan {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		int n = scan.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
				String s= scan.next();
				String[] temp = s.split("");
				for (int j = 0; j < temp.length; j++) {
					arr[i][j] = temp[j].equals(".") ? 0 : 3;
				}
		}
		scan.close();
		int final_n = n;
		if (final_n > 6) {
			int modN = n % 4;
			final_n = modN == 3 ? modN : modN + 4;
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] > 0) {
					arr[i][j] = --arr[i][j];
				}
			}
		}

		
		if (final_n > 1) {
			for (int k = 1; k < final_n; k++) {
				boolean introduce1 = false;
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (arr[i][j] == 1) {
							introduce1 = true;
							explodeBomb(arr, r, c, i, j);
						} else {
							if (arr[i][j] == 0 && !introduce1) {
								arr[i][j] = 3;
							} else if (arr[i][j] != 0) {
								arr[i][j] = --arr[i][j];
							}
						}
					}
				}
			}
		}

		printMX(arr, r, c);
	}

	private static void explodeBomb(int[][] arr, final int r, final int c,final  int i, final int j) {
		arr[i][j] = 0;
		int bi = i;
		int bj = j;
		//top
		bi = i - 1;
		bj = j;
		if (bi >= 0) {
			arr[bi][bj] = 0;
		}
		//bottom
		bi = i + 1;
		bj = j;
		if (bi < r) {
			if (arr[bi][bj] != 1) {
				arr[bi][bj] = 0;
			}
		}
		//left
		bi = i;
		bj = j - 1;
		if (bj >= 0) {
			arr[bi][bj] = 0;
		}
		//right
		bi = i;
		bj = j + 1;
		if (bj < c) {
			if (arr[bi][bj] != 1) {
				arr[bi][bj] = 0;
			}
		}
	}

	private static void printMX(int[][] arr, int r, int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				 System.out.print(arr[i][j] == 0 ? "." : "O");
			}
			System.out.println();
		}
	}

	
}
