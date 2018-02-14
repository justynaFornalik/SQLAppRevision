package model;

public class Applicant extends Person {
    private int applicationCode;

    public Applicant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Applicant(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
    }

    public Applicant(String firstName, String lastName, String phoneNumber, String email, int applicationCode) {
        super(firstName, lastName, phoneNumber, email);
        this.applicationCode = applicationCode;
    }

    public int getApplicationCode() {
        return applicationCode;
    }

    @Override
    public String toString(){
        return super.toString() + ", " + applicationCode;
    }
}
