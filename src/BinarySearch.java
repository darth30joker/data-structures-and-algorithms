import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
    }

    /**
     *  5 1 5 8 12 13
     *  5 8 1 23 1 11
     */
    private static int binarySearch(int[] a, int x) {
        if (a.length == 1) {
            if (a[0] != x) {
                return -1;
            }
        } else {
            if (a[0] > x || a[a.length - 1] < x) {
                return -1;
            }
        }

        return startBinarySearch(0, a, x);
    }

    private static int startBinarySearch(int currentPosition, int[] a, int x) {
//        System.out.println(String.format("value to find: %s, current array: %s", x, Arrays.toString(a)));
        if (a.length == 1 && a[0] != x) {
            return -1;
        }

        int middle = a.length / 2;

        if (a[middle] == x) {
            return currentPosition + middle;
        } else if (a[middle] > x) {
            return startBinarySearch(currentPosition, Arrays.copyOfRange(a, 0, middle), x);
        } else {
            return startBinarySearch(currentPosition + middle + 1, Arrays.copyOfRange(a, middle + 1, a.length), x);
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
}
