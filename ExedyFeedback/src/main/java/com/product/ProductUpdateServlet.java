package com.product;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductRegistrationDAO productRegistrationDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		productRegistrationDAO = new ProductRegistrationDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String username = request.getParameter("username");

		if (action.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));

			ProductRegistrationDAO dao = new ProductRegistrationDAO();
			ProductRegistration product = dao.getProductRegistration(id);
			request.setAttribute("product", product);

			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateFeedback.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("updateFeed")) {

			// Retrieve form data

			int id = Integer.parseInt(request.getParameter("productId"));
			String category = request.getParameter("category");
			String functionality = request.getParameter("functionality");
			String performance = request.getParameter("performance");
			String usability = request.getParameter("usability");
			String cost = request.getParameter("cost");
			String value = request.getParameter("value");
			String customerFeedback = request.getParameter("customerFeedback");
			String environmentalFeedback = request.getParameter("environmentalFeedback");

			productRegistrationDAO.updateProductRegistration(id, category, functionality, performance, usability, cost, value, customerFeedback, environmentalFeedback);
			

			RequestDispatcher dispatcher = request.getRequestDispatcher("ProductDetails.jsp");
			dispatcher.forward(request, response);

		}

		

	}

}
