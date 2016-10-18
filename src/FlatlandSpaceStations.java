import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int c[] = new int[m];
		for (int c_i = 0; c_i < m; c_i++) {
			c[c_i] = in.nextInt();
		}
		in.close();
		Arrays.sort(c);
		int max = 0;
		for (int i = 0; i < n; i++) {
			int near_right = 0;
			int near_left = 0;
			int nearest = 0;
			for (int j = 0; j < m; j++) {
				if (c[j] == i) {
					break;
				}
				if (i > c[m - 1]) {
					near_right = i - c[m - 1];
					near_left = i - c[m - 1];
					break;
				}
				if (i < c[0]) {
					near_right = c[0] - i;
					near_left = c[0] - i;
					break;
				}
				if (i >= c[j] && i <= c[j+1]) {
					near_right = i - c[j];
					near_left = c[j+1] - i;
					break;
				}
			}
			if (near_right < near_left) {
				nearest = near_right;
			} else {
				nearest = near_left;
			}
			if (max < nearest) {
				max = nearest;
			}
		}
		System.out.println(max);
	}
}
