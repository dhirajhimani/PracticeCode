
public class MyMergeSort {

	private int[] array;
	private int[] tempMergArr;
	private int length;
	private int swaps = 0;

	public static void main(String a[]) {

		int[] inputArr = {1 ,2 ,5 ,3 ,7 ,8 ,6 ,4};
		MyMergeSort mms = new MyMergeSort();
		mms.sort(inputArr);
		for (int i : inputArr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("\n " + mms.swaps);
	}

	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				countSwaps(array[k] , tempMergArr[i]);
				array[k] = tempMergArr[i];
				i++;
			} else {
				countSwaps(array[k] , tempMergArr[j]);
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			countSwaps(array[k] , tempMergArr[i]);
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}
	
	private void countSwaps(int A_k, int temp) {
		if (A_k != temp && A_k > temp) {
			swaps++;
		}
	}
}
