package java.src.Class06.singleton;

public class SingletonExample01 {

    /*
        싱글톤 (singleton)

        - 전체 프로그램에서 단 하나의 객체만 만들도록 보장해야 하는 경우에 단 하나만 생성된 객체
        - 클래스 외부에서 new 연산자로 생성자를 호추할 수 없도록 막아야 한다.
        - 생성자 앞에 private 접근 제한자를 붙여주어야 한다.

        - 자신의 타입인 정적 필드를 하나 선언하고 자신의 객체를 생성해 초기화
          (클래스 내부에서는 new 연산자로 생성자 호출이 가능하다.)
        - 정적 필드도 private 접근 제한자를 붙여 외부에서 필드값을 변경하지 못하도록 한다.
          (대신 외부에서 호출할 수 있는 정적 메소드인 getInstance()를 선언하고 정적 필드에서 참조하고 있는 자신의 객체를 리턴)
    */

    // 정적 필드
    private static SingletonExample01 sigleton = new SingletonExample01();

    // 생성자
    private SingletonExample01() {}

    // 정적 메소드
    static SingletonExample01 getInstance() {
        return sigleton;
    }

    /*
        외부에서 객체를 얻는 유일한 방법 : getInstance() 메소드 호출
        getInstance() 메소드 : 단 하나의 객체만 리턴

        클래스 변수1 = 클래스.getInstance();
        클래스 변수2 = 클래스.getInstance();
        -> 변수1과 변수2는 동일한 객체를 참조한다.
    */
}
