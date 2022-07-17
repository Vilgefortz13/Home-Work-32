import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static List<VendingMachine> drinks = new ArrayList<>();
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        for (int i = 0; i < 20; i++) {
            int random = new Random().nextInt(4) + 1;
            switch (random){
                case 1 -> drinks.add(new Water("Water", 35));
                case 2 -> drinks.add(new Coffee("Coffee", 70));
                case 3 -> drinks.add(new Milk("Milk", 50));
                case 4 -> drinks.add(new Tea("Tea", 55));
                default -> System.out.println();
            }
        }

        drinks.forEach(System.out::println);
    }
}