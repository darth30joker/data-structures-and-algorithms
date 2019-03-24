import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaximumAdvertisementRevenue {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        final List<Integer> firstLineItems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            firstLineItems.add(scanner.nextInt());
        }

        final List<Integer> secondLineItems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            secondLineItems.add(scanner.nextInt());
        }

        System.out.println(getMaximumAdvertisementRevenue(n, firstLineItems, secondLineItems));
    }

    private static long getMaximumAdvertisementRevenue(final int n, final List<Integer> firstLineItems, final List<Integer> secondLineItems) {
        firstLineItems.sort(Comparator.comparing((left) -> left));

        secondLineItems.sort(Comparator.comparing((left) -> left));

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += firstLineItems.get(i) * secondLineItems.get(i);
        }

        return result;
    }
}
