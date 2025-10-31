package Week6.FruitShop;

public class OrderDetail {
    private Fruit fruit;
    private int quantity;

    public OrderDetail(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int add) {
        if (add > 0) this.quantity += add;
    }

    public double getAmount() {
        return fruit.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %3d | %.2f$ | %.2f$", 
                fruit.getName(), quantity, fruit.getPrice(), getAmount());
    }
}