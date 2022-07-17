public class Milk extends VendingMachine {
    public Milk(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("[%d] - %s", price, name);
    }
}
