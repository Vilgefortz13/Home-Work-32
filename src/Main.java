import java.util.*;

public class Main {
    static List<VendingMachine> drinks = new ArrayList<>();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        VendingMachine[] vMachine = {
                new Water("Water", 35),
                new Coffee("Coffee", 70),
                new Milk("Milk", 50),
                new Tea("Tea", 55)
        };

        for (int i = 0; i < 20; i++) {
            int random = new Random().nextInt(4) + 1;
            switch (random) {
                case 1 -> drinks.add(vMachine[0]);
                case 2 -> drinks.add(vMachine[1]);
                case 3 -> drinks.add(vMachine[2]);
                case 4 -> drinks.add(vMachine[3]);
                default -> System.out.println();
            }
        }
        System.out.print("""
                Choose an action:
                  add money - 1;
                  buy water - 2;
                  buy coffee - 3;
                  buy milk - 4;
                  buy tea - 5;
                >\040""");
        int action = getNumber(1, 5);
        int deposit = 0;

        switch (action) {
            case 1 -> {
                System.out.print("How much money do you want to add: ");
                int money = getNumber();
                deposit += money;
            }
            case 2 -> {
                for (VendingMachine v : vMachine) {
                    if (v.getPrice() >= deposit) {
                        drinks.remove(vMachine[0]);
                    }
                }
            }
            case 3 -> {
                for (VendingMachine v : vMachine) {
                    if (v.getPrice() >= deposit) {
                        drinks.remove(vMachine[1]);
                    }
                }
            }
            case 4 -> {
                for (VendingMachine v : vMachine) {
                    if (v.getPrice() >= deposit) {
                        drinks.remove(vMachine[2]);
                    }
                }
            }
            case 5 -> {
                for (VendingMachine v : vMachine) {
                    if (v.getPrice() >= deposit) {
                        drinks.remove(vMachine[3]);
                    }
                }
            }
        }
    }

    private static void printDrinks(VendingMachine[] list) {
        for (VendingMachine v : list) {
            System.out.printf("[%d] - %s%n", v.getPrice(), v.getName());
        }
    }

    public static int getNumber() {
        int number;
        while (true) {
            try {
                System.out.print("Enter the number: ");
                number = new Scanner(System.in).nextInt();
                while (number < 0) {
                    System.out.print("Invalid value! Enter the positive number: ");
                    number = new Scanner(System.in).nextInt();
                }
                return number;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value! Try again: ");
            }
        }
    }

    public static int getNumber(int startValue, int endValue) {
        int number;
        while (true) {
            try {
                System.out.print("Enter the number: ");
                number = new Scanner(System.in).nextInt();
                while (number < startValue || number > endValue) {
                    System.out.printf("Invalid value! Enter from %d to %d: ", startValue, endValue);
                    number = new Scanner(System.in).nextInt();
                }
                return number;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value! Try again: ");
            }
        }
    }
}