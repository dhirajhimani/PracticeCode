import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-array-left-rotation
// Arrays: Left Rotation
public class ArrayRotation {

//	public static int[] arrayRotation(int[] a, int n, int k) {
//		if (n - k == 0 || k == 0) {
//			return a;
//		}
//		k = k % n;
//		
//		int mid = n % 2 == 0 ? n/2 : (n/2 + 1);
//		int rotateBy = -1;
//		if (k <= mid) {
//			// Left Rotate by k
//			rotateBy = k;
//			return arrayLeftRotation(a, n, rotateBy);
//		} else {
//			// Right Rotate by k-mid
//			rotateBy = k - mid;
//			return arrayRightRotation(a, n, rotateBy);
//		}
//	}
//	
//	public static int[] arrayLeftRotation(int[] a, int n, int k) {
//		
//	}
//	
//	public static int[] arrayRightRotation(int[] a, int n, int k) {
//		
//	}
	
	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		if (n - k == 0 || k == 0) {
			return a;
		}
		if (k > n) {
			if (k % n == 0) {
				return a;
			}else {
				k = k % n;
			}
		}
		if (n / k == 2) {
			for (int i = 0; i < k; i++) {
				int temp = a[i + k];
				a[i + k] = a[i];
				a[i] = temp;
			}
		} else {

			int valueI = a[0];
			int swapIndex =  n + 0 - k;
			for (int i = 0; i < n; i++) {
				int temp = a[swapIndex];
				a[swapIndex] = valueI;
				valueI = temp;
				swapIndex = swapIndex - k;
				swapIndex = swapIndex < 0 ? n + swapIndex : swapIndex;
			}
		}
		
		return a;
	}
//	public static int[] arrayLeftRotation(int[] a, int n, int k) {
//		if (n - k == 0 || k == 0) {
//			return a;
//		}
//		k = k % n;
//		int valueI = a[n - 1];
//		int swapIndex =  n - 1 - k;
//		for (int i = 0; i < n; i++) {
//			int temp = a[swapIndex];
//			a[swapIndex] = valueI;
//			valueI = temp;
//			swapIndex = swapIndex - k;
//			swapIndex = swapIndex < 0 ? n + swapIndex : swapIndex;
//		}
//		return a;
//	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		
		int[] output = new int[n];
		output = arrayLeftRotation(a, n, k);
		for (int i = 0; i < n; i++)
			System.out.print(output[i] + " ");

		System.out.println();

	}
}
