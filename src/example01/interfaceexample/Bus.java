package example01.interfaceexample;

public class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("Bus is running");
    }

    public void checkFare() {
        System.out.println("승차 요금 체크");
    }
}
