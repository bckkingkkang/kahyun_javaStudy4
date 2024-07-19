package org.example.imagedrag.example01.inheritance;

public class ChildExample02 {
    public static void main(String[] args) {
        // 자동 타입 변환
        // Child child = new Child();
        // Parent parent = child;
        Parent parent = new Child();

        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        // 자식에게 있는 field2, method3() 사용 불가
        // parent.field2 = "data2";
        // parent.method3();

        // 강제 타입 변환
        Child child = (Child) parent;
        child.field2 = "data2";
        child.method3();
    }
}
