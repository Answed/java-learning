package BankClasses;

public class Person {
    String first_name;
    String middle_name;
    String last_name;

    int age;
    String social_security_number;

    public Person(String first, String middle, String last, int age, String ssn){
        this.first_name = first;
        this.middle_name = middle;
        this.age = age;
        this.social_security_number = ssn;
    }
}
