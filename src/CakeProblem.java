import java.util.Scanner;

public class CakeProblem {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];
        int max = Integer.MIN_VALUE;
        for(int height_i=0; height_i < n; height_i++){
        	int temp = in.nextInt();
            height[height_i] = temp;
            if (max < temp) {
            	max = temp;
            }
        }
        in.close();
        int[] candles_count = new int[max];
        for(int height_i=0; height_i < n; height_i++){
        	candles_count[height[height_i] - 1 ]++;
        }
        System.out.println(candles_count[max - 1]);
    }
}
