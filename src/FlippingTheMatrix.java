import java.util.*;


//        1
//        2
//        112 42 83 119
//        56 125 56 49
//        15 78 101 43
//        62 98 114 108


//https://www.hackerrank.com/challenges/flipping-the-matrix
public class FlippingTheMatrix {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            int q = scanner.nextInt();//Query
            while (q-- > 0) {
                int n = scanner.nextInt();//Matrix N
                int m = 2 * n;
                int[][] matrix = new int[m][m];

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < m; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        List arr = Arrays.asList(matrix[i][j],
                                                 matrix[i][m - 1 - j],
                                                 matrix[m - 1 - i][j],
                                                 matrix[m - 1 - i][m - 1 - j]);
                        arr.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer int1, Integer int2) {
                                return int2 - int1;
                            }
                        });
                        sum += Integer.parseInt(arr.get(0).toString());
                    }
                }
                System.out.println(sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}