import java.util.Scanner;

//https://www.hackerrank.com/challenges/strange-advertising
public class ViralAdvertising {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int initial = 5;
		in.close();
		System.out.println(liked(initial, n) + "");
	}

	private static int liked(int initial, int n) {
		if (n == 0) {
			return n;
		}
		int like = initial / 2 ;
		return like + liked(like * 3, n - 1);
	}
	
}
