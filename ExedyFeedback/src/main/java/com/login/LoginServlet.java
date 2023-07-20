package com.login;

import com.product.*;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;
	private ProductRegistrationDAO dao;

	public void init() {
		String jdbcURL = "jdbc:mysql://localhost:3306/srs";
		String jdbcUsername = "root";
		String jdbcPassword = "root";
		loginDAO = new LoginDAO(jdbcURL, jdbcUsername, jdbcPassword);
		dao = new ProductRegistrationDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String userType = loginDAO.getUserType(username, password);


		if (userType != null) {
			// Set the list of products as an attribute in the request
			request.getSession().setAttribute("username", username);
			if (userType.equals("user")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ProductDetails.jsp");
				dispatcher.forward(request, response);
			} else if (userType.equals("analyst")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("AnalystProductDetails.jsp");
				dispatcher.forward(request, response);
			} else if (userType.equals("admin")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminWelcome.jsp");
				dispatcher.forward(request, response);

			}
		} else {
			// If invalid user, redirect to login.jsp with error message
			response.sendRedirect("error.jsp");
		}

	}
}
