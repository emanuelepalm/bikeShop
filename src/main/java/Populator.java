import people.Buyer;
import people.People;
import shop.BikeShop;
import veichles.Bike;

import java.util.ArrayList;

public interface Populator {
    public Buyer buyerPopulate();
    public Bike bikePopulate();
    public ArrayList<Bike> bikePopulate(int num);
    public People ownerPopulate();
    public BikeShop populate();
    }
