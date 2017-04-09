package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kacper on 18.10.2016.
 */
public class InsertRecord {

    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/sakila";

    public void insertRecord() throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;

        String insertTableSQL =
                "insert into cars (car_name) values ('succes')";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(insertTableSQL);

            statement.executeUpdate(insertTableSQL);

            System.out.println("Record is inserted into DBUSER table!");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                statement.close();
            }
        }
    }

    private Connection getDBConnection() {

        Connection dbConnection = null;

        try{

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(DB_CONNECTION, "root", "root");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return dbConnection;
    }

}
