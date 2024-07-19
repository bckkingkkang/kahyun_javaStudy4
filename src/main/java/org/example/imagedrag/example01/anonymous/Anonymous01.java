package org.example.imagedrag.example01.anonymous;

public class Anonymous01 {

    // 필드 초기값으로 대입
    // 필드값으로 익명 객체 대입
    Person01 field = new Person01() {
        void work() {
            System.out.println("출근");
        }

        @Override
        void wake() {
            System.out.println("wake at 6");
            work();
        }
    };

    void method1() {
        // 로컬 변수 값으로 대입
        // 로컬 변수 값으로 익명 객체 대입
        Person01 localVar = new Person01() {
            void walk() {
                System.out.println("산책");
            }
            @Override
            void wake() {
                System.out.println("wake at 7");
                walk();
            }
        };
        // 로컬 변수 사용
        localVar.wake();
    }

    void method2(Person01 person) {
        person.wake();
    }
}
