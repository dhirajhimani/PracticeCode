
import java.util.Scanner;

// https://www.hackerrank.com/challenges/bonetrousle

//4
//12 8 3
//10 3 3
//9 10 2
//9 10 2
public class Bonetrousle4 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int tc, b;
	    int n, k, tmin, tmax;
	    
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
		        	int tsum = tmin;
		        	int[] arr = new int[b];
		        	for (int i = 0; i < b; i++) {
		        		arr[i] = i + 1;
					}
		        	int remain = n - tsum;
		        	int forward = k;
		        	if (forward > n) {
		        		forward = k - 1;
		        	}
		            for (int i = b - 1; i >= 0; i--) {
		            	int toAdd = forward - arr[i];
		            	remain -= toAdd;
		            	if (remain <= 0) {
		            		arr[i] += toAdd + remain;
		            		break;
		            	} else {
		            		arr[i] += toAdd;
		            	}
		            	forward--;
		            }
		            print(arr);
		        }
		        else {
		        	System.out.println("-1");
		        }
		}
		scan.close();
	}
	
	private static void print(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + (j != arr.length - 1 ? " " : ""));
		}
		System.out.println();
	}
}