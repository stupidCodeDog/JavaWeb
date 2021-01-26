package com.bigshow.javaweb.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


public class DataSourceTest {
    public static void main(String[] args) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
        try {
//            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/users?useUidcode=true&characterEncoding=UTF-8");
//            dataSource.setUser("root");
//            dataSource.setPassword("123456");
////            设置初始化连接个数
//            dataSource.setInitialPoolSize(20);
////            最大的连接个数
//            dataSource.setMaxPoolSize(40);
////            设置每次增加连接的个数
//            dataSource.setAcquireIncrement(5);
////            最小剩余的连接数
//            dataSource.setMinPoolSize(2);
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
