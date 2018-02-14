package controller;

import dao.ApplicantDao;
import dao.ApplicantDaoSQLite;
import model.Applicant;
import view.MenuView;

import java.sql.SQLException;

public class ApplicantController {

    private MenuView menuView = new MenuView();
    private ApplicantDao applicantDao = new ApplicantDaoSQLite();

    void showApplicantsNames() {
        try {
            for (Applicant applicant : applicantDao.selectFullName()) {
                menuView.printMessage(applicant.getFullName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    void showApplicantByName(){
        String firstName = menuView.getInput("Enter first name: ");
        try{
            for(Applicant applicant: applicantDao.findApplicantsByName(firstName)){
                menuView.printMessage(applicant.toString());
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }

    void showApplicantByEmail() {
        String email = menuView.getInput("Enter email: ");
        try{
            for( Applicant applicant: applicantDao.findApplicantByEmail(email)){
                menuView.printMessage(applicant.toString());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    void insertApplicant(){
        Applicant valuesToInsert = menuView.getApplicantInput();
        int result = 0;

        try {
            result = applicantDao.insertApplicant(valuesToInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String status = result > 0 ? "Applicant inserted" : "Applicant not inserted.";
        menuView.printMessage(status);
    }

    void updateApplicant(){
        Applicant valuesToUpdate = menuView.getApplicantUpdate();
        int result = 0;

        try {
            result = applicantDao.updateApplicant(valuesToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String status = result > 0 ? "Applicant updated" : "Applicant not updated.";
        menuView.printMessage(status);
    }

    void deleteApplicant(){
        Applicant valuesToDelete = menuView.getApplicantDelete();
        int result = 0;

        try{
            result = applicantDao.deleteApplicant(valuesToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String status = result > 0 ? "Applicant deleted" : "Applicant not deleted";
        menuView.printMessage(status);
    }
}
