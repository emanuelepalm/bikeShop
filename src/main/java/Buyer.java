public class Buyer extends People{
    private double wallet;
    private Bike wantedBike;

    public Buyer(String firstName, String lastName, String number, double wallet, Bike wantedBike) {
        super(firstName, lastName, number);
        this.wallet = wallet;
        this.wantedBike = wantedBike;
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
