package people;

import shop.BikeShop;
import veichles.Bike;

import java.util.ArrayList;

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
        int index = -1;
        boolean purchase = false;
        if(this.wantedBike.getPrice() <= this.wallet) {
            ArrayList<Bike> inStock = bikeShop.getInStock();
            for (int i = 0; i < inStock.size(); i++){
                if(inStock.get(i).getName() == this.wantedBike.getName()) {
                    index = i;
                    purchase = true;
                }
                if(index>0) {
                    bikeShop.getInStock().remove(index);
                }
            }
        } else {
            purchase = false;
        }
        return purchase;
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
