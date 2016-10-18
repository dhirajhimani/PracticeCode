import java.util.Scanner;

public class StrangeCounter {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final long task = in.nextLong();
		long temp_task = task;
		int counter = get2Pow(temp_task);
//		System.out.println(counter);
		long start_range = (long)(Math.pow(2, counter - 1) - 1) * 3;
		long end_range = Integer.MIN_VALUE;
		long diff = 1;
		if (start_range >= task  || end_range < task) {
			while (start_range >= task || end_range < task) {
				start_range = (long)(Math.pow(2, counter - diff) - 1) * 3;
				end_range = (long)(Math.pow(2, counter - diff + 1) - 1) * 3;
				diff++;
			}
			
		} else {
			end_range = (long)(Math.pow(2, counter - diff) - 1) * 3;
		}
//		
		// According to Q
		start_range++;
//		System.out.println(start_range);
//		System.out.println(end_range);
		
		long startValue = (long)(3 * Math.pow(2, get2Pow((long)start_range) - 1));
//		System.out.println(startValue);
		long rangeValue = (startValue - (task - start_range));
		System.out.println(rangeValue);
	}
	
	private static int get2Pow(long temp_task){
		int counter = 0;
		if (temp_task == 1) {
			return 1;
		}
		while(temp_task != 1){
			temp_task /= 2;
			counter++;
		}
		return counter;
	}
}
