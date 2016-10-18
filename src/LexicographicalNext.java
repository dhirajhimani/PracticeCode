import java.util.Arrays;
import java.util.Scanner;

public class LexicographicalNext {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int task = in.nextInt();
		in.nextLine();
		String[] tasks = new String[task];
		for (int i = 0; i < task; i++) {
			tasks[i] = in.nextLine().toLowerCase();
		}
		int[][] converted_tasks = new int[task][];
		for (int i = 0; i < task; i++) {
			int task_len = tasks[i].length();
			converted_tasks[i] = new int[tasks[i].length()];
			// Fill the task with the Ascii than put algo
			for (int j = 0; j < task_len; j++) {
				converted_tasks[i][j] = tasks[i].charAt(j);
			}
		}
//		for (int i = 0; i < task; i++) {
//			int task_len = tasks[i].length();
//			for (int j = 0; j < task_len; j++) {
//				System.out.print(converted_tasks[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < task; i++) {
			int task_len = converted_tasks[i].length;
			boolean founded = false;
			Integer[] temp_task = new Integer[task_len];
			for (int j = 0; j < temp_task.length; j++) {
				temp_task[j] = converted_tasks[i][j];
			}
			for (int j = task_len - 1; j >= 1; j--) {
				
				for (int k = j - 1; k >= 0; k--) {
					int element = converted_tasks[i][j];
					if (element > converted_tasks[i][k]) {
						if (!isSorted(converted_tasks[i], k + 1)) {
							continue;
						}
						founded = true;
						swap(temp_task, j, k);
						Arrays.sort(temp_task, k + 1, converted_tasks[i].length);
						break;
					}
				}
				if (founded) {
					String nextLexico = "";
					for (int k = 0; k < task_len; k++) {
						nextLexico += (char) (int) temp_task[k];
					}
					if (nextLexico.equals(converted_tasks[i])) {
						System.out.println("no answer");
					} else {
						System.out.println(nextLexico);
					}
					break;
				}
			}
			if (!founded) {
				System.out.println("no answer");
			}

		}

	}

	private static void swap(Integer[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static boolean isSorted(int[] a, int startIndex) {
		for (int i = startIndex; i < a.length - 1; i++) {
	        if (a[i] < a[i + 1]) {
	            return false; // It is proven that the array is not sorted.
	        }
	    }

	    return true; 
	}

}
