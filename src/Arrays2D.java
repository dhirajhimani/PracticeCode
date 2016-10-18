import java.util.Scanner;

public class Arrays2D {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = 0;
				for (int k = i; k < (i + 3); k++) {
					for (int l = j; l < (j + 3); l++) {
						if (k == i + 1 && (l == j  || l == j+2)) {
							continue;
						}
						sum += arr[k][l];
					}
				}
				if (max < sum) {
					max = sum;
				}
			}
		}
		System.out.println(max);
	}
}
