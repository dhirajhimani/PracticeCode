import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/sock-merchant
public class SockMerchant {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c[] = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}
		int totalPairs = 0;
		Map<Integer, Integer> matchesMap = new HashMap<>();
		for (int c_i = 0; c_i < n; c_i++) {
			if (matchesMap.containsKey(c[c_i])) {
				int count = matchesMap.get(c[c_i]);
				if (count == 1) {
					matchesMap.put(c[c_i], 0);
					totalPairs++;
				} else {
					matchesMap.put(c[c_i], ++count);
				}
			} else {
				matchesMap.put(c[c_i], 1);
			}
		}
		System.out.println(totalPairs + "");
	}
}
