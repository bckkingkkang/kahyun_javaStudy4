package example01.interfaceexample;

public class VehicleExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
        // vehicle.checkFare();    vehicle 인터페이스에는 checkFare()가 없음

        // 강제 타입 변환
        Bus bus = (Bus) vehicle;

        bus.run();
        bus.checkFare();
    }
}
