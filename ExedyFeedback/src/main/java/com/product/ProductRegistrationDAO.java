package com.product;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class ProductRegistrationDAO {
	private final String url = "jdbc:mysql://localhost:3306/srs";
	private final String username = "root";
	private final String password = "root";
	private Connection conn;

	public ProductRegistrationDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void createProductRegistration(ProductRegistration product) {
		try {
			String query = "INSERT INTO products (category, username, functionality, performance, "
					+ "usability, cost, value, customer_feedback, environmental_feedback) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, product.getCategory());
			statement.setString(2, product.getUsername());
			statement.setString(3, product.getFunctionality());
			statement.setString(4, product.getPerformance());
			statement.setString(5, product.getUsability());
			statement.setString(6, product.getCost());
			statement.setString(7, product.getValue());
			statement.setString(8, product.getCustomerFeedback());
			statement.setString(9, product.getEnvironmentalImpact());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ProductRegistration getProductRegistration(int id) {
		ProductRegistration product = null;
		try {
			String query = "SELECT * FROM products WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				product = new ProductRegistration();
				product.setId(resultSet.getInt("pid"));
				product.setCategory(resultSet.getString("category"));
				product.setUsername(resultSet.getString("username"));
				product.setFunctionality(resultSet.getString("functionality"));
				product.setPerformance(resultSet.getString("performance"));
				product.setUsability(resultSet.getString("usability"));
				product.setCost(resultSet.getString("cost"));
				product.setValue(resultSet.getString("value"));
				product.setCustomerFeedback(resultSet.getString("customer_feedback"));
				product.setEnvironmentalImpact(resultSet.getString("environmental_feedback"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<ProductRegistration> getAllProducts() {
		List<ProductRegistration> products = new ArrayList<>();
		String query = "SELECT * FROM products";

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				ProductRegistration product = createProductFromResultSet(resultSet);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public List<ProductRegistration> getAllProduct(String uname) {
		List<ProductRegistration> products = new ArrayList<>();
		String query = "SELECT * FROM products where username= ?";

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, uname);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProductRegistration product = createProductFromResultSet(resultSet);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	// Helper method to create a Product object from a ResultSet
	private ProductRegistration createProductFromResultSet(ResultSet resultSet) throws SQLException {
		ProductRegistration product = new ProductRegistration();
		product.setId(resultSet.getInt("pid"));
		product.setCategory(resultSet.getString("category"));
		product.setUsername(resultSet.getString("username"));
		product.setFunctionality(resultSet.getString("functionality"));
		product.setPerformance(resultSet.getString("performance"));
		product.setUsability(resultSet.getString("usability"));
		product.setCost(resultSet.getString("cost"));
		product.setValue(resultSet.getString("value"));
		product.setCustomerFeedback(resultSet.getString("customer_feedback"));
		product.setEnvironmentalImpact(resultSet.getString("environmental_feedback"));

		return product;
	}

	public void updateProductRegistration(int id, String category, String functionality, String performance,
			String usability, String cost, String value, String customerFeedback, String environmentalFeedback) {

		PreparedStatement statement = null;
		try {

// Prepare the SQL statement
			String sql = "UPDATE products SET category = ?, functionality = ?, performance = ?, usability = ?, cost = ?, value = ?, customer_feedback = ?, environmental_feedback = ? WHERE pid = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, category);
			statement.setString(2, functionality);
			statement.setString(3, performance);
			statement.setString(4, usability);
			statement.setString(5, cost);
			statement.setString(6, value);
			statement.setString(7, customerFeedback);
			statement.setString(8, environmentalFeedback);
			statement.setInt(9, id);

// Execute the update statement
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Product registration updated successfully!");
			} else {
				System.out.println("Product registration update failed!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void deleteProductRegistration(int id) {
		try {
			String query = "DELETE FROM products WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProductRegistrationUsername(String uname) {
		try {
			String query = "DELETE FROM products WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, uname);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
