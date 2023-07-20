package com.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductRegistrationDAO dao;
	
	public void init() {
		dao = new ProductRegistrationDAO();
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductRegistration> products = dao.getAllProducts();

        // Set the list of products as an attribute in the request
        request.setAttribute("products", products);

        // Forward the request to the displayProducts.jsp view
        RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayFeedbacks.jsp");
        dispatcher.forward(request, response);
	}

}
