import java.awt.*;

abstract class Car {
    private final int nrDoors; // Number of doors
    private final double enginePower; // Engine power of the car (hp)
    private double currentSpeed; // The current speed of the car (km/h)
    private Color color; // Color of the car
    public final String modelName; // The car model name

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;

        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }
    public void stopEngine() {
        currentSpeed = 0;
    }

    abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    // Realistically, this doesn't really make sense as it implies that the engine is actively used as a brake
    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to assignment instructions
    public void gas(double amount) {
        incrementSpeed(amount);
    }
    // TODO fix this method according to assignment instructions
    public void brake(double amount) {
        decrementSpeed(amount);
    }
}