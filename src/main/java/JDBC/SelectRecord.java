package JDBC;

import java.sql.*;

public class SelectRecord {

    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/sakila";

    public void selectRecord() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectTableSQL =
                "select * from people where Age between ? and ?";
        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);

            preparedStatement.setInt(1, 27);
            preparedStatement.setInt(2, 32);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                Integer id = rs.getInt("Id");
                System.out.println("Id:" + id);
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                preparedStatement.close();
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
