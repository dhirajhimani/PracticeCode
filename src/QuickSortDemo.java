
public class QuickSortDemo {
//	private static int []a;
	static int swaps  = 0;
	public static void main(String[] args) {
		// Get a random generated array
//		int []a = getArray();
//		int []a = {1 ,2 ,5 ,3 ,7 ,8 ,6 ,4};
		int []a = {2, 1, 5, 3, 4};
		
		// prints the given array
		printArray(a);
		
		// sort the array
		sort(a);
		
		System.out.println("");
		
		//prints the sorted array
		printArray(a);
		System.out.println("\n" + swaps);
		
	}
	
	// This method sorts an array and internally calls quickSort 
	public static void sort(int []a){
		int left = 0;
		int right = a.length-1;
			
		quickSort(left, right, a);
	}
	
	// This method is used to sort the array using quicksort algorithm.
	// It takes the left and the right end of the array as the two cursors.
	private static void quickSort(int left,int right, int []a){
		
		// If both cursor scanned the complete array quicksort exits
		if(left >= right)
			return;
		
		// For the simplicity, we took the right most item of the array as a pivot 
		int pivot = a[right];
		int partition = partition(left, right, pivot,a);
		
		// Recursively, calls the quicksort with the different left and right parameters of the sub-array
		quickSort(0, partition-1,a);
		quickSort(partition+1, right, a);
	}
	
	// This method is used to partition the given array and returns the integer which points to the sorted pivot index
	private static int partition(int left,int right,int pivot,int []a){
		int leftCursor = left-1;
		int rightCursor = right;
		while(leftCursor < rightCursor){
                while(a[++leftCursor] < pivot);
                while(rightCursor > 0 && a[--rightCursor] > pivot);
			if(leftCursor >= rightCursor){
				break;
			}else{
				swap(leftCursor, rightCursor, a);
			}
		}
		swap(leftCursor, right, a);
		return leftCursor;
	}
	
	// This method is used to swap the values between the two given index
	public static void swap(int left,int right,int []a){
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		swaps++;
	}
	
	public static void printArray(int []a){
		for(int i : a){
			System.out.print(i+" ");
		}
	}
	
	public static int[] getArray(){
		int size=10;
		int []array = new int[size];
		int item = 0;
		for(int i=0;i<size;i++){
			item = (int)(Math.random()*100); 
			array[i] = item;
		}
		return array;
	}

}
