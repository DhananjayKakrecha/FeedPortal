package com.product;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class ProductFeedbackDAO {
	private final String url = "jdbc:mysql://localhost:3306/srs";
	private final String username = "root";
	private final String password = "root";
	private Connection conn;

	public ProductFeedbackDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void createProductRegistration(ProductFeedback product) {
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
			statement.setString(9, product.getEnvironmentalFeedback());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ProductFeedback getProductRegistration(int id) {
		ProductFeedback product = null;
		try {
			String query = "SELECT * FROM products WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				product = new ProductFeedback();
				product.setId(resultSet.getInt("pid"));
				product.setCategory(resultSet.getString("category"));
				product.setUsername(resultSet.getString("username"));
				product.setFunctionality(resultSet.getString("functionality"));
				product.setPerformance(resultSet.getString("performance"));
				product.setUsability(resultSet.getString("usability"));
				product.setCost(resultSet.getString("cost"));
				product.setValue(resultSet.getString("value"));
				product.setCustomerFeedback(resultSet.getString("customer_feedback"));
				product.setEnvironmentalFeedback(resultSet.getString("environmental_feedback"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<ProductFeedback> getAllProducts() {
		List<ProductFeedback> products = new ArrayList<>();
		String query = "SELECT * FROM products";

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				ProductFeedback product = createProductFromResultSet(resultSet);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public List<ProductFeedback> getProductsByUsername(String uname) {
		List<ProductFeedback> products = new ArrayList<>();
		String query = "SELECT * FROM products where username= ?";

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, uname);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProductFeedback product = createProductFromResultSet(resultSet);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	// Helper method to create a Product object from a ResultSet
	private ProductFeedback createProductFromResultSet(ResultSet resultSet) throws SQLException {
		ProductFeedback product = new ProductFeedback();
		product.setId(resultSet.getInt("pid"));
		product.setCategory(resultSet.getString("category"));
		product.setUsername(resultSet.getString("username"));
		product.setFunctionality(resultSet.getString("functionality"));
		product.setPerformance(resultSet.getString("performance"));
		product.setUsability(resultSet.getString("usability"));
		product.setCost(resultSet.getString("cost"));
		product.setValue(resultSet.getString("value"));
		product.setCustomerFeedback(resultSet.getString("customer_feedback"));
		product.setEnvironmentalFeedback(resultSet.getString("environmental_feedback"));

		return product;
	}
	
	public boolean updateProduct(ProductFeedback product,int id) {
        // Prepare the SQL query
        String query = "UPDATE products SET functionality = ?, usability = ?, performance = ?, cost = ?, value = ?, environmental_feedback = ?, customer_feedback = ?, category = ? WHERE pid = ?";
        
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getFunctionality());
            statement.setString(2, product.getUsability());
            statement.setString(3, product.getPerformance());
            statement.setString(4, product.getCost());
            statement.setString(5, product.getValue());
            statement.setString(6, product.getEnvironmentalFeedback());
            statement.setString(7, product.getCustomerFeedback());
            statement.setString(8, product.getCategory());
            statement.setInt(9, id);
            // Execute the query
            int rowsAffected = statement.executeUpdate();
            
            // Check if the update was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // Update failed or an error occurred
    }

	public void updateCategory(int id, String category) {
		try {
			String query = "UPDATE products SET category = ? WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, category);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUsername(int id, String username) {

	}

	public void updateFunctionality(int id, String functionality) {
		try {
			String query = "UPDATE products SET functionality = ? WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, functionality);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePerformance(int id, String performance) {
		try {
			String query = "UPDATE products SET performance = ? WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, performance);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUsability(int id, String usability) {
		try {
			String query = "UPDATE products SET usability = ? WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, usability);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCost(int id, String cost) {
		try {
			String query = "UPDATE products SET cost = ? WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, cost);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateValue(int id, String value) {
		try {
			String query = "UPDATE products SET value = ? WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, value);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomerFeedback(int id, String customerFeedback) {
		try {
			String query = "UPDATE products SET customer_feedback = ? WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, customerFeedback);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEnvironmentalFeedback(int id, String environmentalFeedback) {
		try {
			String query = "UPDATE products SET environmental_feedback = ? WHERE pid = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, environmentalFeedback);
			statement.setInt(2, id);
			statement.executeUpdate();
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
}
