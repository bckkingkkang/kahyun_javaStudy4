package example01.nested;

public class B {
    int field1;
    void method1() {}

    static int field2;
    static void method2() {}

    class C {
        void method() {
            // 모든 필드와 메소드에 접근할 수 있음
            // 인스턴스 멤버 클래스 안에서는 바깥 클래스의 모든 필드와 모든 메소드에 접근할 수 있다.
            field1 = 10;
            method1();

            field2 = 20;
            method2();
        }
    }
    static class D {
        void method() {
            // 인스턴스 메스도와 필드는 접근할 수 없음
            // 정적 멤버 클래스 안에서는 바깥 클래스의 정적 필드와 메소드에만 접근할 수 있다.
            // field1 = 10;
            // method1();

            field2 = 20;
            method2();
        }
    }
}
