package com.educacionit.profile.web.servlet;


import com.educacionit.profile.beans.User;
import com.educacionit.profile.data.db.DBConnectionManager;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx = req.getServletContext();

        DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("db");

        Connection conn = dbManager.getConnection();

        try {
            String email = req.getParameter("txtEmail");
            String password = req.getParameter("txtPassword");


            Statement stm = conn.createStatement();

            ResultSet resultSet = stm.executeQuery ("SELECT * from public.profile WHERE email='" + email + "' AND password='" + password + "'");


            System.out.println("SELECT * from public.profile WHERE email='" + email + "' AND password='" + password + "'");

            boolean ok = false;

            User u = null;

            //String name = "";

            while (resultSet.next()) {

                ok = true;

                u = new User();
                //name = resultSet.getString("name");
                u.setEmail (resultSet.getString("email"));
                u.setName(resultSet.getString("name"));
                u.setLastName(resultSet.getString("lastname"));

                break;
            }

            if (ok) {
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                resp.sendRedirect("home.jsp");
            } else {

                resp.sendRedirect("index.jsp?err=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }

    }
}
