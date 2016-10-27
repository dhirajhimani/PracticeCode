import java.util.Scanner;

//https://www.hackerrank.com/challenges/repeated-string
public class RepeatedString {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		long n = in.nextLong();
		in.close();
		int sLength = s.length();
		int no_a_s = getA(s);
		long div = n / sLength;
		long count_a = div * no_a_s;
		long remainLength = n % sLength;
		count_a += getA(s.substring(0, (int)remainLength));
		System.out.println(count_a);
	}
	
	private static int getA(String sub) {
		int count = 0;
		for(int i = 0; i < sub.length() ; i++) {
			if(sub.charAt(i) == 'a') {
				count++;
			}
		}
		return count;
	}
}
