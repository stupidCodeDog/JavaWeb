package com.bigshow.javaweb.test;

import com.bigshow.javaweb.entity.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

import java.sql.SQLException;

public class DBUtilsTest {
    private static  Student findById(Integer id){
        Connection connection;
        Student student = null;

        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
            connection = dataSource.getConnection();
            String sql = "select * from user where id = ?";
            QueryRunner queryRunner = new QueryRunner();
//            根据第三个参数不同，返回不同类型的对象,这里可以带多个参数
            student = queryRunner.query(connection, sql, new BeanHandler<>(Student.class),id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }
    public static void main(String[] args) {
        Student student = findById(2);
        System.out.println(student);

    }
}
