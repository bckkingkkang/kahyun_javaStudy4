package example01.field;

public class FinalFieldExample01 {
    public static void main(String[] args) {
        Person p1 = new Person("123456-1234567", "고가현");

        System.out.println(p1.nation);
        System.out.println(p1.name);
        System.out.println(p1.ssn);

        /*
            p1.nation = "USA";
            p1.ssn = "123456-1234566";

            final 필드는 초기값이 저장되면 프로그램 실행 도중에 수정할 수 없다.

            - final 필드에 초기값을 줄 수 있는 방법
            1. 필드 선언 시
            2. 생성자에서
        */

        p1.name = "가현";

    }
}
