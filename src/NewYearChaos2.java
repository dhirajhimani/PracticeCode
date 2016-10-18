import java.util.Scanner;

public class NewYearChaos2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int q[][] = new int[T][];
		for (int i = 0; i < T; i++) {
			int n = in.nextInt();
			q[i] = new int[n];
			for (int j = 0; j < n; j++) {
				q[i][j] = in.nextInt();
			}
		}
		in.close();
		for (int i = 0; i < T; i++) {

			boolean invalid = false;
			int n = q[i].length;
			int swaps = 0;
			for (int j = 0; j < n; j++) {
				int diff = (q[i][j] - 1) - j;
				if (diff > 2) {
					invalid = true;
				}
			}
			for (int k= 0; k < n && !invalid; k++) {
				for (int j = 0; j < n - 1; j++) {
					
					if (q[i][j] > q[i][j + 1]) {
						int c = q[i][j] + q[i][j + 1];
						q[i][j] = c - q[i][j];
						q[i][j + 1] = c - q[i][j + 1];
						swaps++;
						break;
					}
				}
				if (swaps == 0 ) {
					break;
				}
			}
			if (!invalid)
				System.out.println(swaps);
			else
				System.out.println("Too chaotic");
		}
	}

}
