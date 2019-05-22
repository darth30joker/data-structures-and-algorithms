import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumPairwiseProduct {
    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(final InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            } }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    private static long getMaxPairwiseProductNaive(final long[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product, numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    private static long getMaxPairwiseProductFast(final long[] numbers) {
        final long[] sortedNumbers = sort(numbers);

        return sortedNumbers[0] * sortedNumbers[1];
    }

    private static long[] sort(final long[] numbers) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                final int right = j + 1;
                if (numbers[j] > numbers[right]) {
                    final long temp = numbers[j];
                    numbers[j] = numbers[right];
                    numbers[right] = temp;
                }
            }
        }

//        final ArrayList<Long> newList = new ArrayList<>();
//        for (final long num : numbers) {
//            if (!newList.contains(num)) {
//                newList.add(num);
//            }
//        }

//        System.out.println(String.format("  sorted array: %s", newList));

//        return new long[]{newList.get(newList.size() - 2), newList.get(newList.size() -1 )};
        return new long[]{numbers[numbers.length - 2], numbers[numbers.length - 1]};
    }

    public static void main(final String[] args) {
        final FastScanner scanner = new FastScanner(System.in);

        final int n = scanner.nextInt();

        final long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }

        System.out.println(getMaxPairwiseProductFast(numbers));
//        System.out.println(getMaxPairwiseProductNaive(numbers));

//        stressTest(10, 100000);
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    private static long getRandomNumberInRange(long min, long max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (long) (Math.random() * ((max - min) + 1)) + min;
    }

    private static void stressTest(final int maxN, final int maxNumber) {
        while (true) {
            int n = getRandomNumberInRange(2, maxN);
            long[] numbers = new long[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = getRandomNumberInRange(0L, maxNumber);
            }

            System.out.println(String.format("unsorted array: %s", Arrays.toString(numbers)));

            long result1 = getMaxPairwiseProductNaive(numbers);
            long result2 = getMaxPairwiseProductFast(numbers);

            if (result1 == result2) {
                System.out.println("OK");
            } else {
                System.out.println(String.format("Wrong answer, %s, %s", result1, result2));
                break;
            }
        }
    }
}
