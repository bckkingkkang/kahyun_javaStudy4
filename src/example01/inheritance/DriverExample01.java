package example01.inheritance;

public class DriverExample01 {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        // 자동 타입 변환 Vehicle vehicle = bus;
        driver.drive(bus);
        driver.drive(taxi);
    }
}
