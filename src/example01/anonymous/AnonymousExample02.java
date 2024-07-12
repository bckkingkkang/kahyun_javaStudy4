package example01.anonymous;

public class AnonymousExample02 {
    public static void main(String[] args) {
        Anonymous02 anony = new Anonymous02();

        // 익명 객체 필드 사용
        anony.field.turnOn();

        // 익명 객체 로컬 변수 사용
        anony.method1();

        // 익명 객체 매개값 사용
        anony.method2(
                new RemoteControl() {
                    @Override
                    public void turnOn() {
                        System.out.println("Smart TV on");
                    }

                    @Override
                    public void turnOff() {
                        System.out.println("Smart TV off");
                    }
                }
        );
    }
}
