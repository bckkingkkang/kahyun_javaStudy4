package example01.interfaceexample;

public class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("Bus is running");
    }
}
