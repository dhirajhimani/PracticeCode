import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-making-anagrams
// Strings: Making Anagrams
public class MakingAnagrams {
	
	public static int numberNeeded(String first, String second) {
		int[] firstChars = new int[256];
		int[] secondChars = new int[256];
		int numberNeeded = 0;
		for (int i = 0; i < first.length(); i++) {
			firstChars[first.charAt(i)]++;
		}
		for (int i = 0; i < second.length(); i++) {
			secondChars[second.charAt(i)]++;
		}
		for (int i = 0; i < second.length(); i++) {
			if (firstChars[second.charAt(i)] > 0){
				firstChars[second.charAt(i)]--;
				secondChars[second.charAt(i)]--;
			} 
		}
		
		for (int i = 0; i < 256; i++) {
			
			numberNeeded += (firstChars[i] + secondChars[i]);
		}
		return numberNeeded;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		if (a.compareTo(b) >= 0){
			System.out.println(numberNeeded(a, b));
		} else {
			System.out.println(numberNeeded(a, b));
		}
	}
}
