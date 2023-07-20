package com.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RegistrationDAO registrationDAO;
	private RegistrationDAO dao;
	
	@Override
    public void init() throws ServletException {
        // Initialize the RegistrationDAO instance
        registrationDAO = new RegistrationDAO();
        dao = new RegistrationDAO();
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form data from request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");

        String utype = request.getParameter("type");
        
        String type="";
        
        if (dao.isUsernameExists(username)) {
            // Redirect to an error page if the username already exists
            response.sendRedirect("username_already_exists.jsp");
            return;
          }
 
        
        if(utype.equals("user")) {
        	type = "user";
        } else if(utype.equals("admin")) {
        	type = "admin";
        }else if(utype.equals("analyst")){
        	type = "analyst";
        }
        	
        
        // Create a new Registration object
        Registration registration = new Registration(username, password, fullName, email,type);

        // Save the registration data to the database
        registrationDAO.saveRegistration(registration);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
        dispatcher.forward(request, response);
	}

}
