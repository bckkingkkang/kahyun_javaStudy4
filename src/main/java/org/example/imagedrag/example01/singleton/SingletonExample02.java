package org.example.imagedrag.example01.singleton;

public class SingletonExample02 {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if(obj1 == obj2) {
            System.out.println("obj1 and obj2 are the same");
        } else {
            System.out.println("obj1 and obj2 are not the same");
        }
    }
}
