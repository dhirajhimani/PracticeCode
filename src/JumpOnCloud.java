import java.util.Scanner;

public class JumpOnCloud {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 19;
		int k = 19;
		int c[] = { 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1};
//		int n = in.nextInt();
//		int k = in.nextInt();
//		int c[] = new int[n];
		int e = 100;
		int c_i = 0;
		do {
			c_i += k;
			c_i = c_i % n;
			if (c[c_i] == 1) {
				e -= 3;
			} else {
				e -= 1;
			}
		} while (c_i % n != 0);
		System.out.println(e);
	}
}
