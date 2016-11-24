import java.util.Scanner;

// https://www.hackerrank.com/challenges/bon-appetit
public class BonAppétit {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int arr[] = new int[n];
		int total = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			total += arr[i];
		}
		int fair = (total / 2) - (arr[k] / 2);
		int paid = scan.nextInt();
		scan.close();
		if (fair == paid) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(paid - fair);
		}
		
	}
	
}
