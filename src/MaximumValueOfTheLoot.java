import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaximumValueOfTheLoot {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int maxItems = scanner.nextInt();
        final int maxWeight =  scanner.nextInt();

        final List<int[]> items = new ArrayList<>();

        for (int i = 0; i < maxItems; i++) {
            items.add(new int[]{scanner.nextInt(), scanner.nextInt()});
        }

        items.sort(Comparator.comparingDouble(left -> (double) left[0] / (double) left[1]));

        System.out.println(getMaximumItemsAndWeight(maxItems, maxWeight, items));
    }

    private static double getMaximumItemsAndWeight(final int maxItems, final int maxWeight, final List<int[]> items) {
        final int[] finalItemsAndWeight = new int[]{0, 0};
        int currentItem = 0;
        int currentWeight = 0;
        double maxValue = 0;

        while(currentItem < maxItems && currentWeight < maxWeight) {
            currentItem++;

            final int[] lastItem = items.remove(items.size() - 1);

            final int capacity = maxWeight - currentWeight;

            final int maxCanWeight;
            if (capacity > lastItem[1]) {
                maxCanWeight = lastItem[1];
            } else {
                maxCanWeight = capacity;
            }

            currentWeight += maxCanWeight;

            maxValue += (double) lastItem[0] / (double) lastItem[1] * maxCanWeight;
        }

        return new BigDecimal(maxValue).setScale(4, RoundingMode.HALF_EVEN).doubleValue();
    }
}
