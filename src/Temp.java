import java.util.Scanner;

public class Temp {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		int n = scan.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
				String s= scan.next();
				System.out.println(s);
//				String[] temp = s.split("");
//				for (int j = 0; j < temp.length; j++) {
//					arr[i][j] = temp[j].equals(".") ? 0 : 3;
//				}
		}
		scan.close();
    }

}
