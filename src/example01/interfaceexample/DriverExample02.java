package example01.interfaceexample;

public class DriverExample02 {
    public static void main(String[] args) {
        Driver2 driver = new Driver2();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.drive(bus);
        driver.drive(taxi);
    }
}
