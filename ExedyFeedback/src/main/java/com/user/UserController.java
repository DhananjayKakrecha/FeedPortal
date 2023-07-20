package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.ProductRegistrationDAO;
import com.register.RegistrationDAO;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegistrationDAO dao;
    private ProductRegistrationDAO dao2;
    
    @Override
    public void init() throws ServletException {
    	dao = new RegistrationDAO();
    	dao2 = new ProductRegistrationDAO();
    	super.init();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Check if a delete request is made
        if (request.getParameter("deleteUser") != null) {
            String username = request.getParameter("deleteUser");
            // Call the deleteUser() method of UserDAO
            dao.deleteUser(username);
            // Redirect to user-details.jsp
            dao2.deleteProductRegistrationUsername(username);
            response.sendRedirect("UserDetails.jsp");
            
            
            return; // Stop further execution
            
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
    	if (action != null && action.equals("updateRole")) {
    		String role = request.getParameter("role");
            String usern = request.getParameter("usernameChange");

            // Update the user's role in the database
            boolean successch = dao.updateUserRole(usern, role);

            if (successch) {
                // Role change successful
                response.sendRedirect("UserDetails.jsp");
            } else {
                // Role change failed
                response.sendRedirect("error.jsp");
            }
    		
    	}
    	
    	if(action != null && action.equals("generateReport")) {
    		String username = request.getParameter("username");
    		int id = Integer.parseInt(request.getParameter("productId")); 
    		
    		RegistrationDAO dao = new RegistrationDAO();
    		dao.generateReport(id);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
    		dispatcher.forward(request, response);
    		
    	}
	}

}
