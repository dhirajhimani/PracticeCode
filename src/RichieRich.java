import java.util.Scanner;


// #Incomplete

// https://www.hackerrank.com/challenges/richie-rich
public class RichieRich {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        String number = in.next();
        int n = 4;
        int k = 1;
        String number = "35439";

        int numberFirstHalf = Integer.parseInt(number.substring(0, number.length() / 2));
        System.out.println(numberFirstHalf);
        int numberSecondHalf = Integer.parseInt(number.substring((int) Math.ceil((double) number.length() / 2)));
        System.out.println(numberSecondHalf);
        if (numberFirstHalf < numberSecondHalf) {
            int temp = numberFirstHalf;
            numberFirstHalf = numberSecondHalf;
            numberSecondHalf = temp;
        }
        System.out.println(numberFirstHalf);
        System.out.println(numberSecondHalf);
        System.out.println(reverseInt(numberSecondHalf));

    }


    private static int reverseInt(int input) {
        int reversedNum = 0;
        while (input != 0) {
            reversedNum = reversedNum * 10 + input % 10;
            input = input / 10;
        }
        return reversedNum;
    }
}
