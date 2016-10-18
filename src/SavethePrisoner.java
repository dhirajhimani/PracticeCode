import java.util.Scanner;

public class SavethePrisoner {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int task = in.nextInt();
		in.nextLine();
		String[] tasks = new String[task];
		for (int i = 0; i < task; i++) {
			tasks[i] = in.nextLine();
		}
		for (int i = 0; i < task; i++) {
			String[] info = tasks[i].split(" ");
			int N = Integer.parseInt(info[0]);
			int M = Integer.parseInt(info[1]);
			int S = Integer.parseInt(info[2]);
			// int N = 8;
			// int M = 8;
			// int S = 3;

			if (M <= N) {
				int poison = (S + M - 1) % N;
				if (poison == 0) {
					System.out.println(N);
				} else {
					System.out.println(poison);
				}
			} else {
				int poison = ((M % N) + S - 1) % N;
				if (poison == 0) {
					System.out.println(N);
				} else {
					System.out.println(poison);
				}
			}
		}
	}
}
