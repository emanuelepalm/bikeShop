import java.util.ArrayList;

public class BikeShop {
    private People owner;
    private ArrayList<Bike> inStock;
    private double register;
    private boolean isOpen;

    public BikeShop(People owner, ArrayList<Bike> inStock, double register, boolean isOpen) {
        this.owner = owner;
        this.inStock = inStock;
        this.register = register;
        this.isOpen = isOpen;
    }
    public void openShop(People owner) {
        if (owner == this.getOwner() && !this.isOpen) {
            this.isOpen = true;
            this.register = 300.00;
            System.out.println("Negozio aperto! Fondocassa :" + this.register);
        }
    }

    public void closeShop(People owner) {
        if (owner == this.getOwner() && this.isOpen) {
            this.isOpen = false;
            this.register = 0.00;
            System.out.println("Negozio chiuso! Fondocassa :" + this.register);
        }

    }

    public People getOwner() {
        return owner;
    }

    public void setOwner(People owner) {
        this.owner = owner;
    }

    public ArrayList<Bike> getInStock() {
        return inStock;
    }

    public void setInStock(ArrayList<Bike> inStock) {
        this.inStock = inStock;
    }

    public double getRegister() {
        return register;
    }

    public void setRegister(double register) {
        this.register = register;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
