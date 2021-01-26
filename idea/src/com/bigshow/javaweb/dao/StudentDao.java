package com.bigshow.javaweb.dao;

import com.bigshow.javaweb.entity.Student;
import com.bigshow.javaweb.util.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<Student> findAll(){
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = JDBCTools.getConnection();

            String sql = "select * from user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student;
            while(resultSet.next()){
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer score = resultSet.getInt(3);
                Date birthday = resultSet.getDate(4);
                student = new Student(id, name, score, birthday);
                list.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return list;
    }

    public void add(String name, Integer score, Date birthday){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = JDBCTools.getConnection();
//            System.out.println(connection);
            String sql = "insert into user(name, score, birthday) values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,score);
            preparedStatement.setDate(3,birthday);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection, preparedStatement, null);
        }

    }
//    public static void main(String[] args){
//        StudentDao studentDao = new StudentDao();
//        System.out.println(studentDao.findAll());
//    }

    public void deleteById(Integer id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "delete from user where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, null);
        }
    }

    public Student findById(Integer id){
        Connection connection = null;
        String sql ="select * from user where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString(2);
                Integer score = resultSet.getInt(3);
                Date birthday = resultSet.getDate(4);
                student = new Student(id, name, score, birthday);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, null);
        }
        return student;
    }

    public void update(Integer id, String name, Integer score, Date birthday){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = JDBCTools.getConnection();

            String sql = "update user set name = ?, score = ?, birthday = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,score);
            preparedStatement.setDate(3, birthday);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection, preparedStatement, null);
        }

    }
}
