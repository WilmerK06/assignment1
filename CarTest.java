public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    private static void testMove() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.move();
        boolean result = volvo.getPoint().y == 0.1;
        reportResult("Car moved", result);
    }

    private static void testTurnLeft() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.turnLeft();
        volvo.move();
        boolean result = volvo.getPoint().x == -0.1;
        reportResult("Car turned to the left", result);
    }

    private static void testTurnRight() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.turnRight();
        volvo.move();
        boolean result = volvo.getPoint().x == 0.1;
        reportResult("Car turned to the right", result);
    }

    private static void testGas() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(2);
        boolean result = volvo.getCurrentSpeed() != 2.5;
        reportResult("Gas didn't go out of bounds.", result);
    }

    private static void testBrake() {
        Volvo240 volvo = new Volvo240();
        volvo.brake(2);
        boolean result = volvo.getCurrentSpeed() != -2.5;
        reportResult("Brake didn't go out of bounds.", result);
    }

    private static void testCurrentSpeed() {
        Volvo240 volvo = new Volvo240();
        for (int i = 0; i < 81; i++) {
            volvo.gas(1);
        }
        boolean roofResult = volvo.getCurrentSpeed() <= 100;

        volvo.stopEngine();
        volvo.brake(1);
        boolean floorResult = volvo.getCurrentSpeed() >= 0;

        boolean result = roofResult && floorResult;
        reportResult("Current speed is not out of bounds", result);
    }

    private static void testGasPositive() {
        Volvo240 volvo = new Volvo240();
        double tempSpeed = volvo.getCurrentSpeed();
        volvo.gas(1);
        boolean result = volvo.getCurrentSpeed() / tempSpeed > 0;
        reportResult("Gas won't decrease speed", result);
    }

    private static void testBrakeNegative() {
        Volvo240 volvo = new Volvo240();
        double tempSpeed = volvo.getCurrentSpeed();
        volvo.brake(1);
        boolean result = volvo.getCurrentSpeed() / tempSpeed < 0;
        reportResult("Brake won't decrease speed", result);
    }



    static void main() {
        testTurbo();
        testMove();
        testTurnLeft();
        testTurnRight();
        testGas();
        testBrake();
        testCurrentSpeed();
    }
}
