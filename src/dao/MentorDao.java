package dao;

import model.Mentor;

import java.sql.SQLException;
import java.util.List;

public interface MentorDao {

    List<Mentor> selectFulNames() throws SQLException;
    List<Mentor> findMentorsByCity(String getCity) throws SQLException;

}
