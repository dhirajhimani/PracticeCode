import java.util.Scanner;

public class TimelyOrders2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Q = scan.nextInt();

		int Type[] = new int[Q];
		int Weight[] = new int[Q];
		int Timestamp[] = new int[Q];

		for (int i = 0; i < Q; i++) {
			Type[i] = scan.nextInt();
			Weight[i] = scan.nextInt();
			Timestamp[i] = scan.nextInt();
		}
		scan.close();

		for (int i = 0; i < Q; i++) {
			if (Type[i] == 2) {
				int startTime = Timestamp[i] - Weight[i];
				int finishTime = Timestamp[i];
				if (startTime >= 0) {
					int totalWeight = 0;
					for (int j = i - 1; j >= 0; j--) {
						if (Timestamp[j] < startTime) {
							break;
						}
						if (Type[j] == 1 && Timestamp[j] <= finishTime) {
							totalWeight += Weight[j];
						} 
					}
					System.out.println(totalWeight);
				}
			}
		}
	}
}