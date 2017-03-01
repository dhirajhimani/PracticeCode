import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/kmp-problem
public class YetAnotherKMPProblem_2 {

    static int x = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        String input = "";
        while(count < 26) {
            int repeat = in.nextInt();
            char ch = (char)(count + 97);
            while(repeat > 0) {
                input += ch;
                repeat--;
            }
            count++;
        }
//        System.out.println(input);
        char str[] = input.toCharArray();
        System.out.println(sortedPermutations( str ));
    }

    private static String swap(char[] str, int i, int j) {
        char temp;
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        return String.valueOf(str);
    }

    static int findCeil(char str[], char first, int l, int h)
    {
        int ceilIndex = l;

        for (int i = l+1; i <= h; i++)
            if (str[i] > first && str[i] < str[ceilIndex])
                ceilIndex = i;

        return ceilIndex;
    }

    static String sortedPermutations(char str[])
    {
        int size = str.length;

        Arrays.sort(str);

        boolean isFinished = false;
        int smallestSum = Integer.MAX_VALUE;
        String output= "";
        while (!isFinished)
        {
//            System.out.print(String.format("%d  %s ", x++, String.valueOf(str)));
            int temp = computeLPSArray(String.valueOf(str));
//            System.out.println(" " + temp);
            if (temp < smallestSum) {
                smallestSum = temp;
                output = String.valueOf(str);
            }

            int i;
            for (i = size - 2; i >= 0; --i)
                if (str[i] < str[i+1])
                    break;

            if (i == -1)
                isFinished = true;
            else
            {
                int ceilIndex = findCeil(str, str[i], i + 1, size - 1);

                swap(str, i , ceilIndex);

                Arrays.parallelSort(str, i + 1, size);
            }
        }
        return output;
    }


    static int computeLPSArray(String pat) {
        int M = pat.length();
        int lps[] = new int[M];
        int size = 0;
        computeLPSArray(pat, M, lps);
//        System.out.print(" "+Arrays.toString(lps) + " ");
        for (int i = 0; i < M; i++) {
             size += lps[i];
        }
        return size;
    }

    static void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else  // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];

                } else  // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}
