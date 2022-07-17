public class VendingMachine {
    protected Integer price;
    protected String name;

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("[%d] - %s", price, name);
    }
}
