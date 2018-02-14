package model;

public class Person {
    String firstName;
    String lastName;
    String phoneNumber;
    String email;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public String toString(){
        return firstName + ", " +lastName + ", " + phoneNumber + ", " + email;
    }
}
