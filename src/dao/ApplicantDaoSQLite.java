package dao;

import model.Applicant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicantDaoSQLite implements ApplicantDao {

    private DbConnection dbConnection = DbConnection.getInstance();
    private Connection connection;

    public ApplicantDaoSQLite(){
        connection = dbConnection.getConnection();
    }

    public List<Applicant> selectFullName() throws SQLException {
        ArrayList<Applicant> applicants = new ArrayList<>();
        PreparedStatement preparedSelect = connection.prepareStatement("SELECT first_name, last_name FROM applicants");
        ResultSet queryResult = preparedSelect.executeQuery();

        while(queryResult.next()){
            String firstName = queryResult.getString("first_name");
            String lastName = queryResult.getString("last_name");

            Applicant newApplicant = new Applicant(firstName, lastName);
            applicants.add(newApplicant);
        }

        return applicants;
    }

    private  ArrayList<Applicant> fillResultList(ResultSet queryResult) throws SQLException{

        ArrayList<Applicant> applicants = new ArrayList<>();

        while(queryResult.next()){
            String firstName = queryResult.getString("first_name");
            String lastName = queryResult.getString("last_name");
            String phoneNumber = queryResult.getString("phone_number");
            String email = queryResult.getString("email");
            int applicationCode = queryResult.getInt("application_code");

            Applicant newApplicant =  new Applicant(firstName, lastName, phoneNumber, email, applicationCode);
            applicants.add(newApplicant);
        }

        return applicants;
    }
    public List<Applicant> findApplicantsByName(String name) throws SQLException {
        PreparedStatement preparedSelect = connection.prepareStatement("SELECT first_name, last_name, phone_number, email, application_code FROM applicants WHERE first_name LIKE ?;");
        preparedSelect.setString(1, name);
        ResultSet queryResult = preparedSelect.executeQuery();

        return fillResultList(queryResult);
    }

    public List<Applicant> findApplicantByEmail(String email) throws SQLException {
       PreparedStatement preparedSelect = connection.prepareStatement("SELECT first_name, last_name, phone_number, email, application_code FROM applicants WHERE email LIKE ?;");
       preparedSelect.setString(1, email);
       ResultSet queryResult = preparedSelect.executeQuery();
       return fillResultList(queryResult);
    }

    public int insertApplicant(Applicant applicant) throws SQLException{
        PreparedStatement preparedInsert = connection.prepareStatement("INSERT INTO applicants(first_name, last_name, phone_number, email, application_code) VALUES (?,?,?,?,?)");
        preparedInsert.setString(1, applicant.getFirstName());
        preparedInsert.setString(2, applicant.getLastName());
        preparedInsert.setString(3, applicant.getPhoneNumber());
        preparedInsert.setString(4, applicant.getEmail());
        preparedInsert.setInt(5, applicant.getApplicationCode());
        return preparedInsert.executeUpdate();
    }

    public int updateApplicant(Applicant applicant) throws  SQLException{
        PreparedStatement preparedUpdate = connection.prepareStatement("UPDATE applicants SET phone_number = ? WHERE first_name = ? AND last_name = ?");
        preparedUpdate.setString(1, applicant.getPhoneNumber());
        preparedUpdate.setString(2, applicant.getFirstName());
        preparedUpdate.setString(3, applicant.getLastName());
        return preparedUpdate.executeUpdate();
    }

    public int deleteApplicant(Applicant applicant) throws SQLException{
        PreparedStatement preparedDelete = connection.prepareStatement("DELETE FROM applicants WHERE first_name = ? AND last_name = ?");
        preparedDelete.setString(1, applicant.getFirstName());
        preparedDelete.setString(2, applicant.getLastName());
        return preparedDelete.executeUpdate();
    }


}
