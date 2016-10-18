import java.util.*;

public class Allmetric_Power2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int Q[][] =  new int[T][];
		for (int i = 0; i < T; i++) {
			int q_size = scan.nextInt();
			Q[i] = new int[q_size];
			for (int j = 0; j < q_size; j++) {
				Q[i][j] = scan.nextInt();
			}
		}
		
		for (int i = 0; i < T; i++) {
			int q_size = Q[i].length;
			for (int j = 0; j < q_size; j++) {
//				System.out.print(Q[i][j] + " ");
				System.out.println(getNearestDiff(Q[i][j]));
			}
		}
	}
	
	public static int getNearestDiff(int N){
		double sqrPowdiff = Math.abs((double)(Math.pow(Math.floor(Math.sqrt(N)), 2) - N));
//		System.out.println("sqrPowdiff = " + sqrPowdiff);
		double e = Math.log(N);
		double b = Math.log(N) / Math.log(Math.log(N));
		double secondDiff = Math.abs((double)(Math.pow(Math.floor(b), Math.floor(e)) - N));
//		System.out.println("secondDiff = " + secondDiff);
		return (int)(secondDiff < sqrPowdiff ? secondDiff : sqrPowdiff);
	}
}
