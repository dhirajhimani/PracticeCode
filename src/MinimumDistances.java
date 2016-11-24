import java.util.Scanner;

// https://www.hackerrank.com/challenges/minimum-distances
public class MinimumDistances {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int A[] = new int[n];
	        for(int A_i=0; A_i < n; A_i++){
	            A[A_i] = in.nextInt();
	        }
	        in.close();
	        int min = Integer.MAX_VALUE;
	        for(int i=0; i < n; i++){
	        	for(int j=i+1; j < n; j++){
		            if (A[i] == A[j]) {
		            	int diff = Math.abs(i - j);
		            	if (diff < min) {
		            		min = diff;
		            	}
		            }
		        }
	        }
	        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	        
	    }
	
}
