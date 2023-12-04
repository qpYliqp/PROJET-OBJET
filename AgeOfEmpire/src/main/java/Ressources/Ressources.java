package Ressources;

public abstract class Ressources {

    String name;
    int quantity;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
