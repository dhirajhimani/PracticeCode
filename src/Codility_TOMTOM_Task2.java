
public class Codility_TOMTOM_Task2 {
	public static void main(String args[]) {
		// System.out.println("result: " + binom(5, 3));
		System.out.println("result: " + binom2(40, 20));
	}

	public static long binom(int n, final int k) {
		final int min = (k < n - k ? k : n - k);
		long bin = 1;
		for (int i = 1; i <= min; i++) {
			bin *= n;
			bin /= i;
			n--;
		}
		return bin;
	}

	public static long binom2(int n, int k) {

		long[][] binomial = new long[n + 1][k + 1];

		// base cases
		for (int i = 0; i <= n; i++) {
			binomial[i][0] = 1;
		}

		for (int j = 1; j <= k; j++) {
			binomial[0][j] = 0;
		}

		// bottom-up dynamic programming
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				binomial[i][j] = binomial[i - 1][j - 1] + binomial[i - 1][j];
			}
		}

		return binomial[n][k];
	}
}
