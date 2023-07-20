package com.product;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductRegistrationDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new ProductRegistrationDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("productId"));
		String username = request.getParameter("username");

		dao.deleteProductRegistration(id);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductDetails.jsp");
		dispatcher.forward(request, response);

	}

}
