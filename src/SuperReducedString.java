import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/reduced-string
// Wrong answer misunderstood
public class SuperReducedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputString = in.next();
        char[] input = inputString.toCharArray();
        Arrays.sort(input);
        filterString(input);
        in.close();
    }

    private static void filterString(char[] input) {
        String output = "";
        int count = 1;
        String inputString = "" + input[0];
        for (int i = 1; i < input.length; i++) {
            char inp = input[i];
            count++;
            if (!inputString.contains(inp + "")) {
                if (count != 1 && count % 2 != 0 ) {
                    inputString = inputString.substring(0, inputString.length() - 1);
                }
                inputString += inp;
                count = 1;
            }
        }
        if (count % 2 == 0 ) {
            inputString = inputString.substring(0, inputString.length() - 1);
        }
        System.out.println(inputString.length() == 0 ?  "Empty String" : inputString);
    }
}
