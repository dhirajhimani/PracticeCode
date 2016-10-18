import java.util.Scanner;

public class NewYearChaos {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int q[][] = new int[T][];
		for (int a0 = 0; a0 < T; a0++) {
			int n = in.nextInt();
			q[a0] = new int[n];
			for (int q_i = 0; q_i < n; q_i++) {
				q[a0][q_i] = in.nextInt();
			}
		}

		for (int a0 = 0; a0 < T; a0++) {
			int swaps = 0;
			boolean invalid = false;
			int n = q[a0].length;
			for (int q_i = 0; q_i < n; q_i++) {
				if ((q_i + 1) == q[a0][q_i]) {
					continue;
				}
				if ((q_i + 1) > q[a0][q_i]) {
					continue;
				}
				int swaps_did = (q[a0][q_i] - (q_i + 1));
				if (swaps_did <= 2) {
					swaps += swaps_did;
				} else {
					System.out.println("Too chaotic");
					invalid = true;
					break;
				}
			}
			if (!invalid)
				System.out.println(swaps);
		}
	}
}
