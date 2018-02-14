package dao;

import java.sql.*;

public final class DbConnection {

    private static DbConnection instance = null;
    private Connection connection = null;
    private final String DBNAME = "jdbc:sqlite:db.db";

    public static DbConnection getInstance(){
        if(instance == null){
            instance = new DbConnection();
        }
        return instance;
    }

    private void getConnectionToDb(){
        try{
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(DBNAME);
        } catch (SQLException | NullPointerException e){
            System.out.println("Database connection problem");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

}
