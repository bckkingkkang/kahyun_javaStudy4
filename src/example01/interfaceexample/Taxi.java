package example01.interfaceexample;

public class Taxi implements Vehicle {
    @Override
    public void run() {
        System.out.println("Taxi is running");
    }
}
