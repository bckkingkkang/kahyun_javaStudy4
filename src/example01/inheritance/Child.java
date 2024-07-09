package example01.inheritance;

public class Child extends Parent {
    @Override
    public void method2() {
        System.out.println("재정의된 method2()");
    }

    public void method3() {
        System.out.println("새로 정의된 method3()");
    }
}
