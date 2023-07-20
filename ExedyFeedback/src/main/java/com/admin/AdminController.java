package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.ProductRegistration;
import com.product.ProductRegistrationDAO;


public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductRegistrationDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new ProductRegistrationDAO();
		super.init();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductRegistration> products = dao.getAllProducts();

        // Set the list of products as an attribute in the request
        request.setAttribute("products", products);

        // Forward the request to the displayProducts.jsp view
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductDetailsAdmin.jsp");
        dispatcher.forward(request, response);
	}

}
