package dao;

import model.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorDaoSQLite implements MentorDao{

    private DbConnection database = DbConnection.getInstance();
    private Connection connection;

    public MentorDaoSQLite(){
        connection = database.getConnection();
    }

    private List<Mentor> fillResultList(ResultSet queryResult) throws SQLException {
        List<Mentor> mentors = new ArrayList<>();

        while(queryResult.next()) {
            String firstName = queryResult.getString("first_name");
            String lastName = queryResult.getString("last_name");

            Mentor newMentor = new Mentor(firstName, lastName);
            mentors.add(newMentor);
        }

        return mentors;
    }

    public List<Mentor> selectFulNames() throws SQLException{

        PreparedStatement preparedSelect = connection.prepareStatement("SELECT first_name, last_name from mentors;");
        ResultSet queryResult = preparedSelect.executeQuery();

        return fillResultList(queryResult);
    }


    public List<Mentor> findMentorsByCity(String city) throws SQLException{

        PreparedStatement preparedSelect = connection.prepareStatement("SELECT first_name, last_name from mentors WHERE city = ?");
        preparedSelect.setString(1, city);
        ResultSet queryResult = preparedSelect.executeQuery();

        return fillResultList(queryResult);
    }
}
