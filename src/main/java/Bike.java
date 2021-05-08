public class Bike extends Veichle {

    private String brand;

    public Bike() {

    }

    public Bike(String name, int wheelsNumber, boolean readyToMove) {
        super(name, wheelsNumber, readyToMove);
    }
    public Bike(String name, int wheelsNumber, boolean readyToMove, String brand) {
        super(name, wheelsNumber, readyToMove);
        this.brand = brand;

    }

    public void move() {
        if(checkState()) {
            System.out.println("La bicicletta è in grado di muoversi");
        }

    }

    public boolean checkState() {
        if(this.getWheelsNumber() == 2 && this.getReadyToMove()) {
            return true;
        } else {
            return false;
        }
    }

    public int pedal(int pedal, int speed) {
        int distance = 0;
        if(this.checkState()) {
            if(pedal > 0 && 1 <= speed && speed <= 7) {
                for (int i = 0; i <= pedal; i++) {
                    distance =+ (speed*10);
                }
            } else {
                distance = -1;
            }
        }
        return distance;
    }
}
