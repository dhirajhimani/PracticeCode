import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int c[] = new int[n];
		for (int c_i = 0; c_i < m; c_i++) {
			c[in.nextInt()] = 1;
		}
		in.close();
		int d1[] = new int[n];// right
		int d2[] = new int[n];// left
		for (int i = 0; i < d1.length; i++) {
			if ( c[i] == 1) {
				d1[i] = 0;
			} else {
				d1[i] = (i > 0 ? d1[i - 1] : 0) + 1;
			}
		}
		for (int i = d2.length - 1; i >=0 ; i--) {
			if ( c[i] == 1) {
				d2[i] = 0;
			} else {
				d2[i] = (i < d2.length - 1 ? d2[i + 1] : 0) + 1;
			}
		}
		Arrays.sort(d1);
		Arrays.sort(d2);
		if (d1[n -1] < d2[n-1]) {
			System.out.println(d1[n -1]);
		} else {
			System.out.println(d2[n -1]);
		}
	}
}
