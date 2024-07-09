package example01.finalfield;

public class Person {
    final String nation = "KOREA";
    final String ssn;
    String name;

    public Person(String ssn, String name) {
        this.ssn = ssn;
        this.name = name;
    }
}
