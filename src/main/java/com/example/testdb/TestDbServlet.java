package com.example.testdb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        // get connection to database

        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to database: " + jdbcURL);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);

            out.println("Success!");

            myConn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ServletException(exception);
        }


    }
}
