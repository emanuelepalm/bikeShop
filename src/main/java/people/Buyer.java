package people;

import shop.BikeShop;
import veichles.Bike;

public class Buyer extends People{
    private double wallet;
    private Bike wantedBike;

    public Buyer(String firstName, String lastName, double wallet, Bike wantedBike) {
        super(firstName, lastName);
        this.wallet = wallet;
        this.wantedBike = wantedBike;
    }
    public boolean pay(BikeShop bikeShop) {
        if(buyBike(bikeShop)) {
            this.wallet -= this.wantedBike.getPrice();
            bikeShop.setRegister(bikeShop.getRegister()+this.wantedBike.getPrice());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean buyBike(BikeShop bikeShop) {
        if(bikeShop.getInStock().contains(this.wantedBike) && this.wantedBike.getPrice() <= this.wallet) {
            bikeShop.getInStock().remove(this.wantedBike);
            return true;
        } else {
            return false;
        }
    }
    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public Bike getWantedBike() {
        return wantedBike;
    }

    public void setWantedBike(Bike wantedBike) {
        this.wantedBike = wantedBike;
    }
}
