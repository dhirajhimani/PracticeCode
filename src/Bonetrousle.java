import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// https://www.hackerrank.com/challenges/bonetrousle

//4
//12 8 3
//10 3 3
//9 10 2
//9 10 2
public class Bonetrousle {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			int b = scan.nextInt();
			if (validSticks(n, k)) {
				int[] arr = new int[b];
				int remain = n - k;
				int toAdd= k;
				if (remain <= 0) {
					remain = n - 1;
					toAdd = 1;
				}
				boolean filled = fillCombo(arr, n, k , b, 0, toAdd, remain);
				filled &= sum(arr) == n;
				print(arr, filled);
			} else {
				print(null, false);
			}
		}
		scan.close();
	}

	private static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static boolean fillCombo(int[] arr, int n, int k, int b, int index, int toAdd, int remain) {
		if (remain > 0 && index < b) {
			if (b - index == 1) {
				arr[index] = remain;
			} else {
				arr[index] = toAdd;
			}
			
			if (uniqueElements(arr)) {
				if (b - index == 1) {
					return nonZero(arr);
				}
				int temp = remain;
				do {
					temp = remain;
					--toAdd;
					temp -= toAdd;
				} while (temp <= 0);
				remain = temp;
				fillCombo(arr, n , k ,b , ++index , toAdd, remain);
			} else {
				fillCombo(arr, n, k , b, 0, k--, n - k);
			}
		}
		
		return uniqueElements(arr) && nonZero(arr);
	}

	private static boolean nonZero(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean uniqueElements(int[] arr) {
		Set set = new TreeSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0 && !set.add(arr[i])) {
				return false;
			}
		}
		return true;
	}

	private static void print(int[] arr, boolean filled) {
		if (filled) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
		
	}

	private static boolean validSticks(long n, long k) {
		long sum = (k * (k + 1))/2;
		return n <= sum;
	}
	
}
