import java.util.Scanner;

// https://www.hackerrank.com/challenges/bonetrousle

//4
//12 8 3
//10 3 3
//9 10 2
//9 10 2
public class Bonetrousle3 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long tc, b;
		long n, k, tmin, tmax;
	    
	    tc = scan.nextInt();
		for (long j = 0; j < tc; j++) {
			 n = scan.nextLong();
			 k = scan.nextLong();
			 b = scan.nextLong();
			 tmin = 0;
		        tmax = 0;
		        for (long i = 0; i < b; i++)
		            tmin += i+1;
		        for (long i = 0; i < b; i++) {
		            tmax += k-i;
		            if (tmax >= n) break;
		        }
		        if (tmin <= n && n <= tmax) {
		        	long tsum = tmin;
		        	long remain = n - tsum;
		        	long forward = k;
		        	if (forward > n) {
		        		forward = k - 1;
		        	}
		        	StringBuilder array = new StringBuilder();
		            for (long i = b - 1; i >= 0; i--) {
		            	long toAdd = forward - (i + 1);
		            	remain -= toAdd;
		            	if (remain <= 0) {
		            		array.append((i + 1 + toAdd + remain) + " ");
		            		for (long l = i - 1; l >= 0; l--) {
		            			array.append((l + 1) + " ");
							}
		            		break;
		            	} else {
		            		array.append((i + 1 + toAdd) + " ");
		            	}
		            	forward--;
		            }
		            System.out.println(array.toString().trim());
		        }
		        else {
		        	System.out.println("-1");
		        }
		}
		scan.close();
	}
}
