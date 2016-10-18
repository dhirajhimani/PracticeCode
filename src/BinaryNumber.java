import java.util.Scanner;

public class BinaryNumber {
	// public static void main(String[] args) {
	// int n = 123449;
	// // convert to binary and split into strings of consecutive ones
	// String[] groupings = Integer.toBinaryString(n).split("0");
	// // sorting strings only composed of a single character ("1") orders them
	// // by length
	// Arrays.sort(groupings);
	//
	// // print length of lexicographically last string
	// System.out.println(groupings[groupings.length - 1].length());
	// }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		int rem = 0;
		int max = 0;
		while (n >= 1) {
			rem = n % 2;
			n /= 2;
			if (rem == 1) {
				count++;
				if (max < count) {
					max = count;
				}
			} else {
				count = 0;
			}
		}
	}
}
