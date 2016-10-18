
public class CandidateCode {
	
	public static void main(String[] args) {
		System.out.println(ConvertingTheCandiesShape(6) + "");
	}
	
	public static int ConvertingTheCandiesShape(int no_of_lines) {
		if (no_of_lines <= 1) {
			return 0;
		}
		int balls_moved  = 0;
		for (int i = 1; i <= no_of_lines; i++) {
			int candies_on_line = getCandies(i);
			if ((candies_on_line - no_of_lines) < 0) {
				balls_moved += (no_of_lines - candies_on_line);
			} else {
				break;
			}
		}
		return balls_moved;
	}
	
	private static int getCandies(int line) {
		return 2 * line - 1;
	}
}
