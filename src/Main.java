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
        int deposit = 0;
        while (true) {
            System.out.println("\nYou deposited " + deposit + " money\n");
            System.out.print("""
                    Choose an action:
                      add money - 1;
                      buy water - 2;
                      buy coffee - 3;
                      buy milk - 4;
                      buy tea - 5;
                      get away from machine - 6
                    >\040""");
            int action = getNumber(1, 6);

            if (action == 6) {
                break;
            }

            switch (action) {
                case 1 -> {
                    System.out.print("How much money do you want to add: ");
                    int money = getNumber();
                    deposit += money;
                }
                case 2 -> {
                    if (vMachine[0].getPrice() <= deposit) {
                        drinks.remove(vMachine[0]);
                        System.out.println("You bought water");
                        deposit -= vMachine[0].getPrice();
                    } else {
                        System.out.println("Not enough money!");
                    }
                }
                case 3 -> {
                    if (vMachine[1].getPrice() <= deposit) {
                        drinks.remove(vMachine[1]);
                        System.out.println("You bought coffee");
                        deposit -= vMachine[1].getPrice();
                    } else {
                        System.out.println("Not enough money!");
                    }
                }
                case 4 -> {
                    if (vMachine[2].getPrice() <= deposit) {
                        drinks.remove(vMachine[2]);
                        System.out.println("You bought milk");
                        deposit -= vMachine[2].getPrice();
                    } else {
                        System.out.println("Not enough money!");
                    }
                }
                case 5 -> {
                    if (vMachine[3].getPrice() <= deposit) {
                        drinks.remove(vMachine[3]);
                        System.out.println("You bought tea");
                        deposit -= vMachine[3].getPrice();
                    } else {
                        System.out.println("Not enough money!");
                    }
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
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