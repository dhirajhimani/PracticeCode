
import java.util.*;

public class Allmetric_Power {
	
	public static void main(String[] args) {

		int N = 1960000;
		double e = Math.log(N);
		System.out.println("e = " + e);
		long e_round = Math.round(e);
		System.out.println("e = " + Math.round(e));
		double b = Math.log(N) / Math.log(Math.log(N));
		System.out.println("b = " + b);
		long b_rounded = Math.round(b);
		System.out.println("b = " + Math.round(b));
		
		System.out.println(Math.pow(b_rounded, e_round));
		System.out.println(Math.pow(Math.floor(b), Math.floor(e)));
		System.out.println("Actual " + Math.pow(5, 9));
		
		System.out.println(getNearestDiff(N));
		
		
//		int N = 40;
//		double e = Math.log10(N);
//		System.out.println("e = " + e);
//		long e_round = Math.round(e);
//		System.out.println("e = " + Math.round(e));
//		double b = Math.log10(N) / Math.log(Math.log10(N));
//		System.out.println("b = " + b);
//		long b_rounded = Math.round(b);
//		System.out.println("b = " + Math.round(b));
//		
//		System.out.println(Math.pow(b_rounded, e_round));
		
	}
	
	public static int getNearestDiff(int N){
		double sqrPowdiff = Math.abs((double)(Math.pow(Math.floor(Math.sqrt(N)), 2) - N));
		System.out.println("sqrPowdiff = " + sqrPowdiff);
		double e = Math.log(N);
		double b = Math.log(N) / Math.log(Math.log(N));
		double secondDiff = Math.abs((double)(Math.pow(Math.floor(b), Math.floor(e)) - N));
		System.out.println("secondDiff = " + secondDiff);
		return (int)(secondDiff < sqrPowdiff ? secondDiff : sqrPowdiff);
	}
	
}
