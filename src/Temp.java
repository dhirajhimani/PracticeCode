
public class Temp {
	public static void main(String args[]) {
//		boolean collides = plusCollide(new PlusInfo(1 , 1, 1),
//										new PlusInfo(3, 1, 1));
		boolean collides = plusCollide(new PlusInfo(6 , 2, 2),
				new PlusInfo(3, 2, 2));
		System.out.println(collides);
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
	
	private static boolean coordCollides(int i1, int j1, int i2, int j2, int s1, int s2) {
		// same align
		if (i1 == i2) {
			if ((s1 + s2 + 2) <= 
					Math.abs(j1 - j2) + 1) {
				return false;
			} else {
				return true;
			}
		} else if (j1 == j2) {
			if ((s1 + s2 + 2) <= 
					Math.abs(i1 - i2) + 1) {
				return false;
			} else {
				return true;
			}
		}
		return false;
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
	

}
