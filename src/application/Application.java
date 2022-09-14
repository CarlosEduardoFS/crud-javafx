package application;

import java.sql.Connection;
import java.sql.SQLException;

import db.DB;
import db.exception.DbException;

public class Application {
    public static void main(String[] args) {
        Connection mysql = DB.getConnection();
        try {
            DB.closeConnection();;
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
