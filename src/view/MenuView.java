package view;

import model.Applicant;

import java.util.Scanner;

public class MenuView {

    public void printMenu(){
        System.out.println("(1) See full names of mentors\n"
        + "(2) See full names of applicants\n"
        + "(3) Find nicknames by city\n"
        + "(4) Find applicant by name\n"
        + "(5) Find applicant by email\n"
        + "(6) Insert applicant\n"
        + "(7) Update phone number\n"
        + "(8) Delete applicant\n"
        + "(9) Exit");

    }

    public String getInput(String message){
        printMessage(message);
        Scanner scanner = new Scanner(System.in);
        String input =scanner.next();
        return input;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public Applicant getApplicantInput() {
        String firstName = getInput("Enter first name: ");
        String lastName = getInput("Enter last name");
        String phoneNumber = getInput("Enter phone number");
        String email = getInput("Enter email address: ");
        String applicationCode = getInput("Enter application code: ");

        return  new Applicant(firstName, lastName, phoneNumber, email, Integer.parseInt(applicationCode));

    }

    public Applicant getApplicantUpdate() {
        String firstName = getInput("Enter first name of an applicant to update: ");
        String lastName = getInput("Enter last name of an applicant to update: ");
        String phoneNumber = getInput("Enter phone number: ");

        return new Applicant(firstName, lastName, phoneNumber);
    }

    public Applicant getApplicantDelete(){
        String firstName = getInput("Enter first name of an applicant to delete: ");
        String lastName = getInput("Enter last name of an applicant to delete: ");

        return new Applicant(firstName, lastName);
    }
}
