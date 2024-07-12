package example01.nested;

/*
    java 7 이전까지는 final 키워드 없이 선언된 매개 변수나 로컬 변수를 로컬 클래스에서 사용하면 컴파일 에러가 발생했지만
    자바 8부터는 final 키워드 없이 선언된 매개 변수와 로컬 변수를 사용해도 컴파일 에러가 발생하지 않는다.

    final 키워드를 붙이지 않아도 final 특성을 가지고 있다.
*/

public class Outter {
    // java 7 이전
    public void method1(final int arg) {
        final int localVariable = 1;
        // arg = 100;
        // localVariable = 100;
        class Inner {
            public void method() {
                int result = arg + localVariable;
            }
        }
    }

    // java 8 이후
    public void method2(int arg) {
        int localVariable = 1;
        // arg = 100;
        // localVariable = 100;
        class Inner {
            public void method() {
                int result = arg + localVariable;
            }
        }
    }
}
