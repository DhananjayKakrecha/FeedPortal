package com.register;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.product.ProductRegistration;
import com.product.ProductRegistrationDAO;

public class RegistrationDAO {
	private final String url = "jdbc:mysql://localhost:3306/srs";
	private final String username = "root";
	private final String password = "root";

	public void saveRegistration(Registration registration) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO users (username, password, fullname, email,type) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, registration.getUsername());
			statement.setString(2, registration.getPassword());
			statement.setString(3, registration.getFullName());
			statement.setString(4, registration.getEmail());
			statement.setString(5, registration.getType());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Registration> getAllUsers() {
		ArrayList<Registration> userList = new ArrayList<>();

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
			String query = "SELECT * FROM users";
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String fullName = resultSet.getString("fullname");
				String type = resultSet.getString("type");

				Registration user = new Registration(username, password, email, fullName, type);
				userList.add(user);

			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	public void deleteUser(String uname) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "DELETE FROM users WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, uname);
			statement.executeUpdate();

			// Close resources and connections
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean updateUserRole(String uname, String role) {
		boolean success = false;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			// Establish a database connection
			connection = DriverManager.getConnection(url, username, password);

			// Prepare the SQL statement
			String sql = "UPDATE users SET type = ? WHERE username = ?";
			statement = connection.prepareStatement(sql);

			// Set the parameters
			statement.setString(1, role);
			statement.setString(2, uname);

			// Execute the update
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				// Role update successful
				success = true;
			}

			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}

	public boolean isUsernameExists(String uname) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection
						.prepareStatement("SELECT username FROM users WHERE username = ?");) {
			statement.setString(1, uname);
			try (ResultSet resultSet = statement.executeQuery()) {
				return resultSet.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public void generateReport(int productId) {
		ProductRegistrationDAO dao = new ProductRegistrationDAO();
		ProductRegistration product = dao.getProductRegistration(productId);

		try (PDDocument document = new PDDocument()) {
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
				contentStream.beginText();
				contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
				contentStream.setLeading(14.5f); // Set the line spacing
				contentStream.moveTextPositionByAmount(100, 700);
				contentStream.showText("Product Report");
				contentStream.newLine();
				contentStream.showText("-----------------------------");
				contentStream.newLine();

				// Add product data to the report
				// Example: Iterate over products and add their details
				contentStream.showText("username: " + product.getUsername());
				contentStream.newLine();
				contentStream.showText("product_id: " + product.getId());
				contentStream.newLine();
				contentStream.showText("functionality: " + product.getFunctionality());
				contentStream.newLine();
				contentStream.showText("usability: " + product.getUsability());
				contentStream.newLine();
				contentStream.showText("performance: " + product.getPerformance());
				contentStream.newLine();
				contentStream.showText("cost: " + product.getCost());
				contentStream.newLine();
				contentStream.showText("value: " + product.getValue());
				contentStream.newLine();
				contentStream.showText("environmental_impact: " + product.getEnvironmentalImpact());
				contentStream.newLine();
				contentStream.showText("customer_feedback: " + product.getCustomerFeedback());
				contentStream.newLine();
				contentStream.showText("category: " + product.getCategory());
				contentStream.newLine();

				contentStream.endText();

			}

			File outputFile = new File("C:\\Users\\Dhananjay\\Downloads\\product_report" + productId + ".pdf");
			document.save(outputFile);

			System.out.println("Report saved at: " + outputFile.getAbsolutePath());

			// Open the generated PDF report using the default system viewer
			Desktop.getDesktop().open(outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
