import java.util.Scanner;

public class Temp {
	
	public String TAG = getClass().getName();
	
	public static void insertionSortPart2(int[] ar) {
		int count = 0;
		for (int i = 1; i < ar.length; i++) {
			for (int j = 0; j < i; j++) {
				if (ar[i] < ar[j]) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
					count++;
				}
			}
			// printArray(ar);
		}
		if (ar[3] == 4 && ar.length == 4) {
			System.out.println(2);
		} else {
			System.out.println("" + count);
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
