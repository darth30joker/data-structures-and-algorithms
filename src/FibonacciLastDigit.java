import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciLastDigit {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(getFibonacci(scanner.nextInt()));
    }

    private static long getFibonacci(final int n) {
        if (n <= 1) {
            return (long) n;
        }

        final List<Long> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(0L);
        fibonacciNumbers.add(1L);

        for(int i = 2; i <= n; i++) {
            fibonacciNumbers.add((fibonacciNumbers.get(i - 2) + fibonacciNumbers.get(i - 1)) % 10);
        }

        return fibonacciNumbers.get(n);
    }
}
