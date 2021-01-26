package com.bigshow.javaweb.util;

import java.sql.*;

public class JDBCTools {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/users?useUidcode=true&characterEncoding=UTF-8";
    private static String user = "root";
    private static String password = "123456";

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
