import java.util.Arrays;
import java.util.TreeSet;

public class Codility_TOMTOM_Task1 {
	
	public static void main(String[] args) {
		int[] A = {5, 4, 4, 5, 0, 12};
		System.out.println("solution = " + new Codility_TOMTOM_Task1().solution(A));
//		System.out.println(printDistinct(A, A.length));
	}
	
	public int solution(int[] A) {
		int length = A.length;
		TreeSet<Integer> biValueSet = new TreeSet<>();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				biValueSet.add(getBivaluedSize(i, j, A));
			}
		}
		
        return biValueSet.isEmpty() ? 0 : biValueSet.last();
    }
	
	private int getBivaluedSize(int start, int end, int[] A) {
		int temp[] = Arrays.copyOfRange(A, start, end +1);
		int different_digits = getDistinct(temp, temp.length);
		if (different_digits <=2 ) {
			int range = end - start + 1;
			return range;
		} else {
			return 0;
		}
	}
	
	private int getDistinct(int arr[], int n)
	{
		int different_digits = 0;
	    for (int i = 0 ; i < n ; i++)
	    {
	        int j;
	        for (j=0; j<i; j++) {
	           if (arr[i] == arr[j])
	               break;
	        }
	 
	        if (i == j) {
	        	different_digits++; 
	        }
	    }
	    return different_digits;
	}
}
