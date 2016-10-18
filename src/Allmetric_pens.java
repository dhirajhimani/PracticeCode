import java.util.*;

class Allmetric_pens {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		Set<Integer> penIds = new HashSet<>();
		int[] N = new int[T];
		int[][] P = new int[T][];
		int[][] M = new int[T][];
		for (int i = 0; i < T; i++) {
			N[i] = scan.nextInt();
			int p_size = scan.nextInt();
			int m_size = scan.nextInt();
			P[i] = new int[p_size];
			for (int j = 0; j < p_size; j++) {
				P[i][j] = scan.nextInt();
			}
			M[i] = new int[m_size];
			for (int j = 0; j < m_size; j++) {
				M[i][j] = scan.nextInt();
			}
		}
		
		for (int i = 0; i < T; i++) {
			penIds.clear();
			int p_size = P[i].length;
			int m_size = M[i].length;
			for (int j = 0; j < p_size; j++) {
				penIds.add(P[i][j]);
			}
			for (int j = 0; j < m_size; j++) {
				penIds.add(M[i][j]);
			}
			if (penIds.size() >= N[i]) {
				System.out.println("They can");
			} else {
				System.out.println("They can't");
			}
		}
		
		
//		for (int i = 0; i < T; i++) {
//			System.out.println(N[i] + " " + P[i].length + " " + M[i].length);
//			int p_size = P[i].length;
//			int m_size = M[i].length;
//			for (int j = 0; j < p_size; j++) {
//				System.out.print(P[i][j] + " ");
//			}
//			System.out.println();
//			for (int j = 0; j < m_size; j++) {
//				System.out.print(M[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		
		
		
		
//		for (int i = 0; i < T; i++) {
//			penIds.clear();
//			int N = scan.nextInt();
//			int P = scan.nextInt();
//			int M = scan.nextInt();
//			while(P-- > 0){
//				penIds.add(scan.nextInt());
//			}
//			while(M-- > 0){
//				penIds.add(scan.nextInt());
//			}
//			if (penIds.size() >= N) {
//				System.out.println("They can \n");
//			} else {
//				System.out.println("They can't");
//			}
//			scan.nextLine();
//		}
		scan.close();
	}
}