package JDBC;

import java.sql.SQLException;


public class App {
    public static void main(String[] args) {
//        InsertRecord insertDb = new InsertRecord();
//
//        try {
//            insertDb.insertRecord();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        SelectRecord selectRecord = new SelectRecord();

        try {
            selectRecord.selectRecord();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



