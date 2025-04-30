package com.nail.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.nail.model.UserModel;
import com.nail.service.LoginService;

@WebServlet(asyncSupported = true, urlPatterns = {"/login", "/"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserModel user = new UserModel();
        user.setEmail(email);
        user.setPassword(password);

        LoginService loginService = new LoginService();
        boolean isValidUser = loginService.validateUser(user);

        if (isValidUser) {
            response.sendRedirect("home.jsp"); // Redirect to dashboard
        } else {
            request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
        }
    }
}
