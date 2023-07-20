package com.product;

import javax.servlet.RequestDispatcher;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductRegistrationServlet extends HttpServlet {
	private ProductRegistrationDAO productRegistrationDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		productRegistrationDAO = new ProductRegistrationDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve form data
		String category = request.getParameter("category");
		String username = request.getParameter("username");
		String functionality = request.getParameter("functionality");
		String performance = request.getParameter("performance");
		String usability = request.getParameter("usability");
		String cost = request.getParameter("cost");
		String value = request.getParameter("value");
		String customerFeedback = request.getParameter("customerFeedback");
		String environmentalFeedback = request.getParameter("environmentalFeedback");

		// Create a new ProductRegistration object
		ProductRegistration product = new ProductRegistration();
		product.setCategory(category);
		product.setUsername(username);
		product.setFunctionality(functionality);
		product.setPerformance(performance);
		product.setUsability(usability);
		product.setCost(cost);
		product.setValue(value);
		product.setCustomerFeedback(customerFeedback);
		product.setEnvironmentalImpact(environmentalFeedback);

		// Call DAO method to save the product registration
		productRegistrationDAO.createProductRegistration(product);

		// Redirect to success page
		response.sendRedirect("ProductDetails.jsp");
	}

}
