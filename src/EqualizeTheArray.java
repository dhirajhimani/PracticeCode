import java.util.Scanner;

// https://www.hackerrank.com/challenges/equality-in-a-array
public class EqualizeTheArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] count = new int[101];
		int maxCount = -1;
		
		for (int i = 0; i < n; i++) {
			int temp = in.nextInt();
			count[temp]++;
			if (maxCount < count[temp]) {
				maxCount = count[temp];
			}
		}
		in.close();
		System.out.println(n - maxCount);

	}

}
