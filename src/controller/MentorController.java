package controller;

import dao.MentorDao;
import dao.MentorDaoSQLite;
import model.Mentor;
import view.MenuView;

import java.sql.SQLException;

public class MentorController {

    private MenuView menuView = new MenuView();
    private MentorDao mentorDao = new MentorDaoSQLite();

    void showMentorsNames() {
        try {
            for(Mentor mentor: mentorDao.selectFulNames()){
                menuView.printMessage(mentor.getFullName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void showMentorsByCity() {
        String city = menuView.getInput("Enter city: ");

        try {
            for (Mentor mentor: mentorDao.findMentorsByCity(city)) {
                menuView.printMessage(mentor.getFullName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
