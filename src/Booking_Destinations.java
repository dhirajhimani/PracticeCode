import java.util.Scanner;

public class Booking_Destinations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] infos = in.nextLine().split(" ");
		int n = Integer.parseInt(infos[0]);
		int m = Integer.parseInt(infos[1]);
		int c = Integer.parseInt(infos[2]);
		int unique_cities = n + m - c;
		System.out.println(factorial(unique_cities - 1));
	}

	public static long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}
}
