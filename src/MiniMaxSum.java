import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/mini-max-sum
public class MiniMaxSum {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        long a = in.nextLong();
	        long b = in.nextLong();
	        long c = in.nextLong();
	        long d = in.nextLong();
	        long e = in.nextLong();
	        long[] arr = {a, b, c, d, e};
	        Arrays.sort(arr);
	        long sum = 0;
	        for (int i = 0; i < 4; i++) {
	        	sum += arr[i];
			}
	        System.out.print(sum + " ");
	        sum = 0;
	        for (int i = 1; i < 5; i++) {
	        	sum += arr[i];
			}
	        System.out.print(sum);
	    }
	
}
