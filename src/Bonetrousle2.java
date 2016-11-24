import java.util.Scanner;

// https://www.hackerrank.com/challenges/bonetrousle

//4
//12 8 3
//10 3 3
//9 10 2
//9 10 2
public class Bonetrousle2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int tc, b;
	    int n, k, tmin, tmax, sum, mxset;
	    
	    tc = scan.nextInt();
		for (int j = 0; j < tc; j++) {
			 n = scan.nextInt();
			 k = scan.nextInt();
			 b = scan.nextInt();
			 tmin = 0;
		        tmax = 0;
		        for (int i = 0; i < b; i++)
		            tmin += i+1;
		        for (int i = 0; i < b; i++) {
		            tmax += k-i;
		            if (tmax >= n) break;
		        }
		        if (tmin <= n && n <= tmax) {
		            sum = b*(b+1)/2;
		            mxset = 0;
		            for (int i = b; i >= 1; i--) {
		                if (sum-i+(k-mxset) >= n) {
		                	System.out.print(n - sum + i);
		                    for ( int l = 1; l < b-mxset; l++) {
		                    	System.out.print(" " + (j));
		                    }
		                    for ( int l = k-mxset; l < k; l++) {
		                    	System.out.print(" " + (j + 1));
		                    }
		                    System.out.println();
		                    break;
		                } else {
		                    sum -= i;
		                    sum += (k-mxset);
		                    mxset++;
		                }
		            }
		        }
		        else {
		        	System.out.println("-1");
		        }
		}
		scan.close();
	}
}