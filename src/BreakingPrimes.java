import java.util.Scanner;

public class BreakingPrimes {
	
	 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int A[] = new int[T];
		int B[] = new int[T];
		int K[] = new int[T];
		
		for (int i = 0; i < T; i++) {
			A[i] = scan.nextInt();
			B[i] = scan.nextInt();
			K[i] = scan.nextInt();
		}
		scan.close();
		int max = findMax(B);
		boolean[] primes = new boolean[max + 1];
		for (int i = 0; i < T; i++) {
			printPrimeIfInRange(A[i], B[i], K[i] , primes);
		}
	}

	private static int findMax(int[] b) {
		int max = -1;
		int length = b.length;
		for (int i = 0; i < length; i++) {
			if (b[i] > max) {
				max = b[i];
			}
		}
		return max;
	}

	private static void printPrimeIfInRange(int a, int b, int k, boolean[] primes) {
		if ((a <= 1 && b <= 1 )||
					  b <= 1   ||
					 (b  < a)  ) {
			print(-1);
		} else {
			int count = 0;
			int prime = -1;
			for(int i = a; i <= b ; i++) {
				if (primes[i]) {
					prime = i;
					count++;
				} else if (isPrime(i)) {
					prime = i;
					primes[i] = true;
					count++;
				}
				if (count == k) {
					print(prime);
					return;
				}
			}
			if (count < k) {
				print(-1);
			}
		}
	}
	
	public static void print(int n) {
		System.out.println(n);
	}

	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
