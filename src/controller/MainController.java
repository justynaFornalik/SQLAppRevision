package controller;

import view.MenuView;

public class MainController {

    MentorController mentorController = new MentorController();
    ApplicantController applicantController = new ApplicantController();
    MenuView menuView = new MenuView();

    public void start() {
        String option = "";

        while (!option.equals("0")){

            menuView.printMenu();
            option = menuView.getInput("Enter option: ");

            switch (option) {
                case "1":
                    mentorController.showMentorsNames();
                    break;
                case "3":
                    mentorController.showMentorsByCity();
                    break;
                case "2":
                    applicantController.showApplicantsNames();
                    break;
                case "4":
                    applicantController.showApplicantByName();
                    break;
                case "5":
                    applicantController.showApplicantByEmail();
                    break;
                case "6":
                    applicantController.insertApplicant();
                    break;
                case"7":
                    applicantController.updateApplicant();
                    break;
                case "8":
                    applicantController.deleteApplicant();
                    break;

            }

        }
    }

}
