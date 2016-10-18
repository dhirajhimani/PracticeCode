import java.util.Scanner;

public class ValleyProblem {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
//		int steps_count = 8;
		String step_info = in.next();
//		String step_info = "UUUDUDDDDU";
		int steps_count = step_info.length();
//		if (steps_count != n) {
//			System.out.println("0");
//			return;
//		}
		int valley = 0;
		int steps = 0;
		String last_step = "";
		String UP = "U";
		String DOWN = "D";
		
		for(int i = 0; i < steps_count ; i++) {
			String step = (step_info.charAt(i) + "");
			if (step.equals(UP)) {
				last_step = UP;
				steps++;
			} else {
				last_step = DOWN;
				steps--;
			}
			if (steps == 0 && last_step == UP) {
				valley++;
			}
		}
		System.out.println(valley + "");
	}
}
