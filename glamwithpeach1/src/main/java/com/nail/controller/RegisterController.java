package com.nail.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.nail.model.UserModel;
import com.nail.service.RegisterService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(asyncSupported =  true, urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create UserModel object
        UserModel user = new UserModel();
        user.setName(name);
        user.setCountry(country);
        user.setEmail(email);
        user.setPassword(password);

        // Call service to insert user
        RegisterService service = null;
		try {
			service = new RegisterService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Boolean result = service.addUser(user);

        // Redirect or show error
        if (Boolean.TRUE.equals(result)) {
            response.sendRedirect("login.jsp"); // or dashboard.jsp
        } else {
            request.setAttribute("error", "Registration failed. Please try again.");
            request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
        }
    }
	}

