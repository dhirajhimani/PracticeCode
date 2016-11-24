import java.util.Scanner;

// https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
public class BeautifulDaysMovies {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long i = scan.nextLong();
		long j = scan.nextLong();
		long k = scan.nextLong();
		scan.close();
		long count = 0;
		for ( ;i <= j; i++) {
			if (Math.abs(getReverse(i) - i) % k == 0) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static long getReverse(long num) {
		long rev = 0;
		while(num > 0) {
			int rem = (int)num % 10;
			rev *= 10;
			rev += rem;
			num /= 10;
		}
		return rev;
	}
	
}
