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

    static void main() {
        testTurbo();
        testMove();
        testTurnLeft();
        testTurnRight();
        //TODO: add and run more tests
    }
}
