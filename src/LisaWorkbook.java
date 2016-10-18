import java.util.Scanner;

public class LisaWorkbook {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int lastPage = 1;
		int[] chapter_problems = new int[n];
		int magicProblemCount = 0;
		for (int i = 0; i < n; i++) {
			chapter_problems[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			int problems = chapter_problems[i];
			int pages = getPages(problems, k);
			int cumulativePages = pages + lastPage - 1;
			int problemStartIndex = 0;
			int problemEndIndex = 0;
			for (; lastPage <= cumulativePages; lastPage++) {
				int problemsOnPage = problems - k;
				if (problemsOnPage < 0) {
					problemsOnPage = problems;
				} else {
					problemsOnPage = k;
					problems-=k;
				}
				problemStartIndex = problemEndIndex + 1;
				problemEndIndex = problemStartIndex + problemsOnPage - 1;
				if (problemStartIndex <= lastPage && lastPage <= problemEndIndex) {
					magicProblemCount++;
				}
			}
		}
		System.out.println(magicProblemCount);
		scan.close();
	}
	
	private static int getPages(int problems, int perpage) {
		int div = problems / perpage;
		int rem = problems % perpage;
		if (rem > 0) {
			return div + 1;//Next page will contain remaining problems
		}
		return div;
	}
	
}
