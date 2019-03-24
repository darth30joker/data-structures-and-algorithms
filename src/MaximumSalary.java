import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaximumSalary {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        final List<String> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.next());
        }

        System.out.println(largestNumberAgain(a));
    }

    private static String largestNumberAgain(final List<String> numbers) {
        String answer = "";

        while (numbers.size() > 0) {
            String largest = numbers.get(0);
            int stringToRemove = 0;
            for (int i = 0; i < numbers.size(); i++) {
                final String temp = numbers.get(i);
                if (isGreaterOrEqual(temp, largest)) {
                    largest = temp;
                    stringToRemove = i;
                }
            }

            answer += largest;
            numbers.remove(stringToRemove);
        }

        return answer;
    }

    private static boolean isGreaterOrEqual(String s1, String s2) {
        int result;
        if (s1.length() < s2.length()) {
            final int number1 = Integer.valueOf(s1);
            final int number2 = Integer.valueOf(s2.substring(0, s1.length()));

            if (number1 < number2) {
                result = -1;
            } else if (number1 == number2) {
                if (isGreaterOrEqual(s1, s2.substring(s1.length(), s1.length() + 1))) {
                    result = 1;
                } else {
                    result = -1;
                }
            } else {
                result = 1;
            }
        } else if (s1.length() > s2.length()) {
            final int number1 = Integer.valueOf(s1.substring(0, s2.length()));
            final int number2 = Integer.valueOf(s2);

            if (number1 > number2) {
                result = 1;
            } else if (number1 == number2) {
                if (isGreaterOrEqual(s1.substring(s2.length(), s2.length() + 1), s2)) {
                    result = 1;
                } else {
                    result = -1;
                }
            } else {
                result = -1;
            }
        } else {
            result = Long.valueOf(s1).compareTo(Long.valueOf(s2));
        }

        return result == 1 || result == 0;
    }

    private static Comparator<String> stringComparator = (s1, s2) -> {
        if (s1.length() < s2.length()) {
            final int number1 = Integer.valueOf(s1);
            final int number2 = Integer.valueOf(s2.substring(0, s1.length()));

            if (number2 > number1) {
                return -1;
            } else if (number2 == number1) {
                final int number3 = Integer.valueOf(s2.substring(s1.length(), s1.length() + 1));
                if (number3 >= Integer.valueOf(s1.substring(0, 1))) {
                    return -1;
                }
            }

            return 1;
        } else if (s1.length() > s2.length()) {
            final int number1 = Integer.valueOf(s1.substring(0, s2.length()));
            final int number2 = Integer.valueOf(s2);

            if (number1 > number2) {
                return 1;
            } else if (number1 == number2) {
                final int number3 = Integer.valueOf(s1.substring(s2.length(), s2.length() + 1));
                if (number3 >= Integer.valueOf(s2.substring(0, 1))) {
                    return 1;
                }
            }

            return -1;
        } else {
            return Long.valueOf(s1).compareTo(Long.valueOf(s2));
        }
    };

    private static String largestNumber(final List<String> numbers) {
        numbers.sort(stringComparator);

        final StringBuilder result = new StringBuilder();
        for (final String number : numbers) {
            result.insert(0, number);
        }

        return result.toString();
    }
}
