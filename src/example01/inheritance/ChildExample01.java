package example01.inheritance;

public class ChildExample01 extends Parent{
    public static void main(String[] args) {
        Child child = new Child();

        // 부모 타입으로 자동 타입 변환
        Parent parent = child;

        parent.method1();
        // Child 에서 재정의
        parent.method2();

        /*
            부모 타입으로 자동 타입 변환된 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.
            parent.method3();   // 호출 불가능

        */
    }
}
