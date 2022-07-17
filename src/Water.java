public class Water extends VendingMachine {
    public Water(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("[%d] - %s", price, name);
    }
}
