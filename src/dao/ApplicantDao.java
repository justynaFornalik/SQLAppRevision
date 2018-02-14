package dao;

import model.Applicant;

import java.sql.SQLException;
import java.util.List;

public interface ApplicantDao {

    List<Applicant> selectFullName() throws SQLException;
    List<Applicant> findApplicantsByName(String name) throws SQLException;
    List<Applicant> findApplicantByEmail(String email) throws SQLException;
    int insertApplicant(Applicant applicant) throws SQLException;
    int updateApplicant(Applicant applicant) throws  SQLException;
    int deleteApplicant(Applicant applicant) throws SQLException;

}
