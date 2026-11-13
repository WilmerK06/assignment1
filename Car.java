import java.awt.*;
import java.awt.geom.Point2D;
import java.lang.Math;

abstract class Car implements Movable {
    private final int nrDoors; // Number of doors
    private final double enginePower; // Engine power of the car (hp)
    private double currentSpeed; // The current speed of the car (km/h)
    private Color color; // Color of the car
    private final String modelName; // The car model name

    // Used in movable implementation
    private double angle = (Math.PI / 2); // Angle that car is facing (lower value than the initialized value will turn it to the right and a higher value will turn it to the left)
    private final double turnIncrement = (Math.PI / 2); // Default turn radius setting is 90 degrees
    private final Point2D.Double position = new Point2D.Double(0, 0);

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
    public String getModelName() {
        return modelName;
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

    public void gas(double amount) {
        if (amount > 1 | amount < 0) {
            return;
        }
        incrementSpeed(amount);
        if (getCurrentSpeed() > getEnginePower()) {
            decrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount > 1 | amount < 0) {
            return;
        }
        decrementSpeed(amount);
        if (getCurrentSpeed() < 0) {
            incrementSpeed(amount);
        }
    }

    /*
    MOVABLE IMPLEMENTATION
    */

    public void move() {
        this.position.x += Math.cos(this.angle) * this.getCurrentSpeed();
        this.position.y += Math.sin(this.angle) * this.getCurrentSpeed();
    }

    public void turnLeft() {
        angle += turnIncrement;
    }
    public void turnRight() {
        angle -= turnIncrement;
    }

    public Point2D.Double getPoint() {
        return position;
    }
}