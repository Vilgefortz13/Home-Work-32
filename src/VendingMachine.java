public class VendingMachine {
    protected Integer price;
    protected String name;

    public VendingMachine(Integer price, String name) {
        this.price = price;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
