import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int leftNumber = Integer.parseInt(scanner.next(".*"));
        final int rightNumber = Integer.parseInt(scanner.next(".*"));

        System.out.println(getCommonDivisor(leftNumber, rightNumber));
    }

    private static int getCommonDivisor(final int leftNumber, final int rightNumber) {
        if (rightNumber == 0) {
            return leftNumber;
        }

        return getCommonDivisor(rightNumber, leftNumber % rightNumber);
    }
}
