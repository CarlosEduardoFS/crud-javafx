package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import db.exception.DbException;

public class DB {

    private  static Connection connectionMysql = null;

    public static Connection getConnection(){
        if (connectionMysql == null){
            try {
                Properties props = LoadProperties();
                String url = props.getProperty("dburl");
                connectionMysql = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return connectionMysql;
    }

    public static void closeConnection(){
        if (connectionMysql != null){
            try{
                connectionMysql.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties LoadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
    
}
