package com.bigshow.javaweb.util;

import com.bigshow.javaweb.test.DataSourceTest;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCTools {
    private static Connection connection;
    private static DataSource dataSource;

    static{
        dataSource = new ComboPooledDataSource("testc3p0");
    }
    public static Connection getConnection(){
        try {
            connection = dataSource.getConnection();
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
