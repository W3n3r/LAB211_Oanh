package Week6.FruitShop;

public class OrderDetail {
    private String product;
    private double price;
    private int quantity;

    public OrderDetail(String product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int add) {
        if (add > 0) {
            this.quantity += add;
        }
    }

    public double getAmount() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %3d | %6.2f$ | %7.2f$", 
                product, quantity, price, getAmount());
    }
}


