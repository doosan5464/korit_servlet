package com.korit.servlet_study.servlet.Hello;

import com.korit.servlet_study.entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        List<User> users = new ArrayList<>();

        users.add(new User("aaa", "1111", "aaaaaa", "aaa@gmail.com"));
        users.add(new User("bbb", "1111", "bbbbbb", "bbb@gmail.com"));
        users.add(new User("ccc", "1111", "cccccc", "ccc@gmail.com"));
        users.add(new User("ddd", "1111", "dddddd", "ddd@gmail.com"));
        users.add(new User("eee", "1111", "eeeeee", "eee@gmail.com"));

        config.getServletContext().setAttribute("users", users);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        List<User> users = (List<User>) servletContext.getAttribute("users");

        req.getRequestDispatcher("/WEB-INF/product_user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("email"));
        resp.setContentType("text/html");
    }
}
