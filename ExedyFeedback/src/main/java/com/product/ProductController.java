package com.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductFeedbackDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = new ProductFeedbackDAO();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		
		if(action != null && action.equals("addProduct")){
       	 String functionality = request.getParameter("functionality");
            String usability = request.getParameter("usability");
            String performance = request.getParameter("performance");
            String cost = request.getParameter("cost");
            String value = request.getParameter("value");
            String environmentalImpact = request.getParameter("environmentalImpact");
            String customerFeedback = request.getParameter("customerFeedback");
            String username = request.getParameter("username");
            String category = request.getParameter("category");

            // Create a new Product object with the form data
            ProductFeedback product = new ProductFeedback(category, username, functionality, performance, usability, cost, value, customerFeedback, environmentalImpact);

            // Add the product to the database
            dao.createProductRegistration(product);
          
            if(username.equals("admin")) {
            // Redirect back to the product-details-admin.jsp page
           	 response.sendRedirect("product-details-admin.jsp");
            }
            if(username.equals("user")){
            		response.sendRedirect("Users.jsp");
            }
            else {
           	 response.sendRedirect("viewer.jsp");
            }
        }
		
		if (action.equals("update")) {
            int productId = Integer.parseInt(request.getParameter("id"));
            
            ProductFeedbackDAO dao = new ProductFeedbackDAO();
            
            // Retrieve the product details based on the provided ID
            ProductFeedback product = dao.getProductRegistration(productId);
            
            // Set the product details as a request attribute
            request.setAttribute("products", product);
            
            // Forward the request to the update-product.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateFeedback.jsp");
            dispatcher.forward(request, response);
        }
		
		if(action != null && action.equals("updateProduct")){
	       	 String functionality = request.getParameter("functionality");
	            String usability = request.getParameter("usability");
	            String performance = request.getParameter("performance");
	            String cost = request.getParameter("cost");
	            String value = request.getParameter("value");
	            String environmentalImpact = request.getParameter("environmentalImpact");
	            String customerFeedback = request.getParameter("customerFeedback");
	            String username = request.getParameter("username");
	            int id = Integer.parseInt(request.getParameter("productId"));
	            String category = request.getParameter("category");

	            // Create a new Product object with the form data
	            ProductFeedback product = new ProductFeedback(category, username, functionality, performance, usability, cost, value, customerFeedback, environmentalImpact);

	            // Add the product to the database
	            dao.updateProduct(product,id);

	            // Redirect back to the product-details-admin.jsp page
	            if(username.equals("admin")) {
	                // Redirect back to the product-details-admin.jsp page
	               	 response.sendRedirect("Product-details-admin.jsp");
	                }
	                if(username.equals("user")){
	                		response.sendRedirect("Users.jsp");
	                }
	                else {
	               	 response.sendRedirect("Viewer.jsp");
	                }
	       }
		
		if (action != null && action.equals("deleteProduct")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            dao.deleteProductRegistration(productId);
            
            response.sendRedirect("Users.jsp");
            
        }
	}

}
