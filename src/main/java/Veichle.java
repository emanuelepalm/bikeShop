public abstract class Veichle {
    //attributi
    protected String name;
    protected int wheelsNumber;
    protected boolean readyToMove;

    public Veichle() {

    }
    public Veichle(String name, int wheelsNumber, boolean readyToMove) {
        this.name = name;
        this.wheelsNumber = wheelsNumber;
        this.readyToMove = readyToMove;
    }

    //metodi
    public abstract void move();

    public abstract boolean checkState();

    //getter e setter
    public String getName() {
        return this.name;
    }

    public int getWheelsNumber() {
        return this.wheelsNumber;
    }

    public boolean getReadyToMove() {
        return this.readyToMove;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWheelsNumber(int wheels) {
        wheelsNumber = wheels;
    }

    public void setReadyToMove(boolean ready) {
        readyToMove = ready;
    }
}
