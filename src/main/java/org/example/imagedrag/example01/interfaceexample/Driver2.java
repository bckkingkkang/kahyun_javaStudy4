package org.example.imagedrag.example01.interfaceexample;

public class Driver2 {
    public void drive(Vehicle vehicle) {
        if(vehicle instanceof Bus) {
            Bus bus = (Bus)vehicle;
            bus.checkFare();
        }
        vehicle.run();
    }
}
