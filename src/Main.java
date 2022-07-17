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
            switch (random){
                case 1 -> drinks.add(vMachine[0]);
                case 2 -> drinks.add(vMachine[1]);
                case 3 -> drinks.add(vMachine[2]);
                case 4 -> drinks.add(vMachine[3]);
                default -> System.out.println();
            }
        }
        System.out.print("How much money will you deposit: ");
        int deposit = getNumber();
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
}