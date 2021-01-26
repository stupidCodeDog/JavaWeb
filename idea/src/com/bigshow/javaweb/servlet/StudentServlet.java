package com.bigshow.javaweb.servlet;

import com.bigshow.javaweb.dao.StudentDao;
import com.bigshow.javaweb.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    StudentDao studentDao = new StudentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method == null){
            method = "findAll";
        }

        switch(method){
            case "findAll":
                List<Student> list = studentDao.findAll();
                req.setAttribute("list", list);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "delete":
                String inStr = req.getParameter("id");
                Integer id = Integer.parseInt(inStr);
                studentDao.deleteById(id);
                resp.sendRedirect("/student");
                break;
            case "findById":
                inStr = req.getParameter("id");
                id = Integer.parseInt(inStr);
                req.setAttribute("student", studentDao.findById(id));


                req.getRequestDispatcher("update.jsp").forward(req, resp);

                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
//        System.out.println(req.getCharacterEncoding());
        switch (method){
            case "add":
                String name = req.getParameter("name");
                String scoreStr = req.getParameter("score");
                String birthdayStr = req.getParameter("birthday");
                Integer score = Integer.parseInt(scoreStr);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = null;
                try {
//          把获得的字符串转化为日期
                    birthday = sdf.parse(birthdayStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
//      这里要将util的date转换为sql的date
                java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
//        System.out.println(birthdayStr);
                studentDao.add(name, score, sqlDate);

                break;
            case "update":
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                name = req.getParameter("name");
                scoreStr = req.getParameter("score");
                score = Integer.parseInt(scoreStr);
                birthdayStr = req.getParameter("birthday");
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                birthday = null;
                try {
                //  把获得的字符串转化为日期
                    birthday = sdf.parse(birthdayStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                sqlDate = new java.sql.Date(birthday.getTime());
                studentDao.update(id, name, score, sqlDate);
                break;
        }
        resp.sendRedirect("/student");
    }
}
