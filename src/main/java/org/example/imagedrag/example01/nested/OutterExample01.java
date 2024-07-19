package org.example.imagedrag.example01.nested;

public class OutterExample01 {
    public static void main(String[] args) {
        Outter2 outter = new Outter2();
        Outter2.Nested nested = outter.new Nested();

        nested.print();
    }
}
