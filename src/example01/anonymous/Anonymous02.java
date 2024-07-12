package example01.anonymous;

public class Anonymous02 {
    // 필드 선언과 필드 초기값으로 대입
    RemoteControl field = new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("TV on");
        }

        @Override
        public void turnOff() {
            System.out.println("TV off");
        }
    };

    // 로컬 변수 선언과 초기값 대입
    void method1() {
        RemoteControl localVar = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("Audio on");
            }
            @Override
            public void turnOff() {
                System.out.println("Audio off");
            }
        };
        // 로컬 변수 사용
        localVar.turnOn();
    }

    void method2(RemoteControl rc) {
        rc.turnOn();
    }
}
