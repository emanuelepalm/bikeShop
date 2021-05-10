package veichles;

public class Bike extends Veichle {

    private String brand;
    private boolean brake;
    private double price;


    public Bike() {

    }

    public Bike(String name,double price, boolean readyToMove) {
        super(name, 2, readyToMove);
        this.brand = name;
        this.brake = readyToMove;
        this.price = price;
    }

    public Bike(String name, double price) {
        super(name, 2, true);
        this.brand = name;
        this.brake = true;
        this.price = price;
    }

    public Bike(String name, int wheelsNumber, boolean readyToMove, String brand, double price) {
        super(name, wheelsNumber, readyToMove);
        this.brand = brand;
        this.brake = readyToMove;
        this.price = price;
    }

    public void move() {
        if(checkState()) {
            System.out.println("La bicicletta è in grado di muoversi");
        }
    }

    public double getPrice() {
            return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean checkState() {
        System.out.println("Controllo bicicletta");
        if(this.getWheelsNumber() == 2 && this.getReadyToMove()  && this.brake) {
            return true;
        } else {
            return false;
        }
    }

    public int pedal(int pedal, int speed) {
        int distance = 0;
        if(this.checkState()) {
            if(pedal > 0 && 1 <= speed && speed <= 7) {
                for (int i = 1; i <= pedal; i++) {
                    distance += (speed*10);
                }
            } else {
                distance = -1;
            }
        }
        return distance;
    }
}
