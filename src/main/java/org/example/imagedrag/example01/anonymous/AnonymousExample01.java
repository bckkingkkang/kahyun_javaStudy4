package org.example.imagedrag.example01.anonymous;

public class AnonymousExample01 {
    public static void main(String[] args) {
        Anonymous01 anony = new Anonymous01();

        // 익명 객체 필드 사용
        anony.field.wake();

        // 익명 객체 로컬 변수 사용
        anony.method1();

        // 익명 객체 매개값 사용
        anony.method2(
                new Person01() {
                    void study() {
                        System.out.println("study");
                    }
                    @Override
                    void wake() {
                        System.out.println("wake at 8");
                        study();
                    }
                }
        );
    }
}
