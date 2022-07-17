import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    }

    public static void printDrinks(VendingMachine[] list) {
        for (VendingMachine v : list) {
            System.out.printf("[%d] - %s%n", v.getPrice(), v.getName());
        }
    }
}