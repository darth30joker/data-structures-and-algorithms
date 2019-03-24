import java.util.Scanner;

public class MoneyChange {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(getMoneyChange(scanner.nextInt()));
    }

    private static int getMoneyChange(int money) {
        int tens = money / 10;

        int fives = (money - tens * 10) / 5;

        int ones = money - tens * 10 - fives * 5;

        return tens + fives + ones;
    }
}
