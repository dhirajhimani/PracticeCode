import java.util.Scanner;

// https://www.hackerrank.com/challenges/find-digits
public class FindDigits {

	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++) {
	            int n = in.nextInt();
	            int count = 0;
	            int temp = n;
	            while(temp > 0) {
	            	int rem = temp % 10;
	            	temp /= 10;
	            	if (rem > 0 && n % rem == 0) {
	            		count++;
	            	}
	            }
	            System.out.println(count);
	        }
	        in.close();
	    }
	
}
