import java.util.Scanner;

// https://www.hackerrank.com/challenges/fair-rations
public class FairRations {

	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int N = in.nextInt();
	        int B[] = new int[N];
	        for(int B_i=0; B_i < N; B_i++){
	            B[B_i] = in.nextInt();
	        }
	        in.close();
	        boolean valid = true;
	        int breads = 0;
	        boolean breadGiven = false;
	        for (int i = 0; i < N; i++) {
				if (B[i] % 2 != 0) {
					B[i]++;
					breads++;
					if ((i - 1) >= 0 && B[i - 1] % 2 != 0) {
						breadGiven = true;
						B[i - 1]++;
						breads++;
					} else if ((i + 1) < N) {
						if (!breadGiven) {
							B[i + 1]++;
							breads++;
						}
					} else if ( !breadGiven &&  (i + 1) == N) {
						valid = false;
					}
				}
			}
	        if (!valid) {
	        	System.out.println("NO");
	        } else {
	        	System.out.println(breads);
	        }
	    }
	
}
