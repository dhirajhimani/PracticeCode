import java.util.Scanner;

// https://www.hackerrank.com/challenges/two-pluses
public class EmaSupercomputer {
	
	public static boolean isBad(String var) {
		return var.equals(BAD);
	}


	public static class PlusInfo {


		int i;

		int j;
		int plusSize;
		public PlusInfo(int i, int j, int plusSize) {
			this.i = i;
			this.j = j;
			this.plusSize = plusSize;
		}

		public int getSize() {
			return (plusSize * 4) + 1 ;
		}


		@Override
		public String toString() {
			return "(" + i + ", " + j + ") " + plusSize;
		}

	}
	private static boolean plusCollide(PlusInfo plus1, PlusInfo plus2) {
		if (plus1.plusSize == 0 || plus2.plusSize == 0) {
			return false;
		}
		// same align
		if (plus1.i == plus2.i) {
			if ((plus1.plusSize + plus2.plusSize + 2) <=
					Math.abs(plus1.j - plus2.j) + 1) {
				return false;
			} else {
				return true;
			}
		} else if (plus1.j == plus2.j) {
			if ((plus1.plusSize + plus2.plusSize + 2) <=
					Math.abs(plus1.i - plus2.i) + 1) {
				return false;
			} else {
				return true;
			}
		}

		//Traverse Plus2
		boolean collide = false;
		for (int starSize = 1 ; starSize <= plus2.plusSize ; starSize++) {

			//Top
			int topi = plus2.i - starSize;
			if (plus1.i == topi && Math.abs(plus1.j - plus2.j) <= plus1.plusSize)  {
				collide = true;
				break;
			}
			//Bottom
			int bottomi = plus2.i + starSize;
			if (plus1.i == bottomi && Math.abs(plus1.j - plus2.j) <= plus1.plusSize) {
				collide = true;
				break;
			}
			// Left
			int leftj = plus2.j - starSize;
			if (plus1.j == leftj && Math.abs(plus1.i - plus2.i) <= plus1.plusSize)  {
				collide = true;
				break;
			}
			// Right
			int rightj = plus2.j + starSize;
			if (plus1.j == rightj && Math.abs(plus1.i - plus2.i) <= plus1.plusSize)  {
				collide = true;
				break;
			}
		}

		return collide;
	}

//	private static boolean plusCollide(PlusInfo plus1, PlusInfo plus2) {

//			if (plusContains(i, plus1.j, plus2)) {
//			i = plus1.i + starSize;
//			//Bottom
//
//			}
//				break;
//				collide = true;
//			if (plusContains(i, plus1.j, plus2)) {
//			int i = plus1.i - starSize;
//			//Top
//
//		for (int starSize = 1 ; starSize <= plus1.plusSize ; starSize++) {
//		//take one point of plus1 and check in plus2
//		//traverse plus1
//		}
//			return false;
//		if (plus1.plusSize == 0 || plus2.plusSize == 0) {
//		boolean collide = false;
private static String GOOD = "G";
	private static String BAD = "B";

	private static PlusInfo plusInfo1 = new PlusInfo(-1, -1, 0);
	private static PlusInfo plusInfo2 = new PlusInfo(-1, -1, 0);
	private static PlusInfo[] plusInfos;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		String[][] arr = new String[r][c];
		for (int i = 0; i < r; i++) {
			String s = scan.next();
			String[] temp = s.split("");
			for (int j = 0; j < temp.length; j++) {
				arr[i][j] = temp[j];
			}
		}
		scan.close();

		//printArr(arr, r, c);

		int er = r - 1;
		int ec = c - 1;
		int max_pluses = r * c / 2;
		plusInfos = new PlusInfo[max_pluses];
		int count = 0;

		for (int i = 1; i < er ; i++) {
			for (int j = 1; j < ec ; j++) {
				if (isGood(arr[i][j])) {
					int plus_size = getPlusSize(arr, i, j , 1, r, c);
					if (plus_size > 0) {
						while (plus_size > 0) {
							plusInfos[count++] = new PlusInfo(i, j, plus_size);
							plus_size--;
						}

//						assignMax(plus_size, i , j);
					}

				}
			}
		}
		System.out.println("count " + count);

		plusInfo1 = plusInfos[0] != null ? plusInfos[0] : new PlusInfo(-1,  -1, 0);
		plusInfo2 = new PlusInfo(-1, -1, 0);
		for (int i = 0 ;i < count ; i++) {
			for (int j = 0; j < count && i != j; j ++) {
//				System.out.println("" + plusInfos[i] + " | " + plusInfos[j] + " = " + plusInfos[i].getSize() * plusInfos[j].getSize());
				if ((plusInfos[i].getSize() * plusInfos[j].getSize() >
						plusInfo1.getSize() * plusInfo2.getSize())
						&&
						!plusCollide(plusInfos[i], plusInfos[j])) {
					plusInfo1 = plusInfos[i];
					plusInfo2 = plusInfos[j];
				}
			}
		}
		System.out.println(plusInfo1);
		System.out.println(plusInfo2);
		if (!plusCollide(plusInfo1, plusInfo2)) {
			System.out.println(plusInfo1.getSize() * plusInfo2.getSize());
		} else {
			System.out.println(plusInfo1.getSize() > plusInfo2.getSize()
					? plusInfo1.getSize() :
					plusInfo2.getSize());
		}

	}

	private static void printArr(String[][] arr, int r , int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int getPlusSize(String[][] arr, final int i, final int j, int startSize, int r , int c) {
		boolean valid = true;
		//Top
		int topi = i - startSize;
		if (!(topi >= 0 && isGood(arr[topi][j])))  {
			valid = false;
		}
		//Bottom
		int bottomi = i + startSize;
		if (valid && !(bottomi < r  && isGood(arr[bottomi][j]))) {
			valid = false;
		}
		// Left
		int leftj = j - startSize;
		if (valid && !(leftj >= 0 && isGood(arr[i][leftj])))  {
			valid = false;
		}
		// Right
		int rightj = j + startSize;
		if (valid && !(rightj < c && isGood(arr[i][rightj])))  {
			valid = false;
		}


		if (valid) {
			return getPlusSize(arr, i, j, ++startSize, r, c);
		} else {
			return --startSize;
		}
	}

	public static boolean isGood(String var) {
		return var.equals(GOOD);
	}
//				collide = true;
//				break;
//			}
//
//			//Left
//			int j = plus1.j - starSize;
//			if (plusContains(plus1.i, j, plus2)) {
//				collide = true;
//				break;
//			}
//
//			//Right
//			j = plus1.j + starSize;
//			if (plusContains(plus1.i, j, plus2)) {
//				collide = true;
//				break;
//			}
//		}
//		
//		return collide;
//	}
//	
//	private static boolean plusContains(int x, int y, PlusInfo plusInfo) {
//		boolean contains = false;
//		for (int starSize = 1 ; starSize <= plusInfo.plusSize ; starSize++) {
//			//Top
//			int i = plusInfo.i - starSize;
//			int j = plusInfo.j;
//			if (x == i && y == j) {
//				contains = true;
//				break;
//			}
//			//Bottom
//			i = plusInfo.i + starSize;
//			j = plusInfo.j;
//			if (x == i && y == j) {
//				contains = true;
//				break;
//			}
//			//Left
//			i = plusInfo.i;
//			j = plusInfo.j - starSize;
//			if (x == i && y == j) {
//				contains = true;
//				break;
//			}
//			//Right
//			i = plusInfo.i;
//			j = plusInfo.j + starSize;
//			if (x == i && y == j) {
//				contains = true;
//				break;
//			}
//			
//		}
//		return contains;
//	}
}
