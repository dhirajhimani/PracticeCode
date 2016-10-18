import java.util.Scanner;

public class NewYearChaos3 {
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
				// check if the array is too chaotic
				int diff = q[i][j] - 1 - j;
				if (diff > 2) {
					invalid = true;
					break;
				}
			}
			for (int j = n - 1; j >= 0 && !invalid; j--) {
				int q_j  = q[i][j];
				for (int k = Math.max(0, q_j - 2); k < j; k++) {
				int q_k  = q[i][k];
					if (q_k  > q_j) {
						swaps++;
					}
				}
			}
			if (!invalid)
				System.out.println(swaps);
			else
				System.out.println("Too chaotic");
		}
	}

}
