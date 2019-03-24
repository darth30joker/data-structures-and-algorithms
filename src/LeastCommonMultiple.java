import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final long leftNumber = Long.parseLong(scanner.next(".*"));
        final long rightNumber = Long.parseLong(scanner.next(".*"));

        final long commonDivisor = getCommonDivisor(leftNumber, rightNumber);

        System.out.println(leftNumber * rightNumber / commonDivisor);
    }

    private static long getCommonDivisor(final long leftNumber, final long rightNumber) {
        if (rightNumber == 0) {
            return leftNumber;
        }

        return getCommonDivisor(rightNumber, leftNumber % rightNumber);
    }
}
