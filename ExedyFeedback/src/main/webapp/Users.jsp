<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.product.*"%>
<%@ page import="java.util.List"%>

<%
// Get the logged-in username from your authentication or session management mechanism
String loggedInUsername = (String) request.getSession().getAttribute("username"); // Replace with your implementation

// Create a ProductDAO object
ProductFeedbackDAO productDAO = new ProductFeedbackDAO();

// Retrieve the products associated with the logged-in username
List<ProductFeedback> products = productDAO.getProductsByUsername(loggedInUsername);
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Registered Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<style>
.dis {
	display: flex;
	gap: 5px;
}
</style>
<body>
	<%
	String username = request.getParameter("username");
	%>
	<div class="container-fluid">
		<header
			class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
			<a href="./index.html"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<img src="./images/box-fill.svg" alt="Box" height="30"> <span
				class="fs-4 ps-2">Exedy</span>
			</a>

			<ul class="nav nav-pills">
				<li class="nav-item"><a href="./AddFeedback.jsp?username=${username}"
					class="nav-link">Add Feedback</a></li>
				<li class="nav-item"><a href="./DisplayFeedbacks.jsp">View all Feedbacks</a></li>
			</ul>
		</header>
	</div>
	<div class="container">
		<h1 class="mt-5">Products for <%= loggedInUsername %></h1>
		<div class="card-group">
			<div class="row">
				<c:forEach var="product" items="${products}">
					<div class="card" style="width: 18rem;">
						<img src="./images/person-circle.svg" height="100"
							class="card-img-top" alt="">
						<div class="card-body">
							<h5 class="card-title">
								ProFeedback Id: ${product.id} <br> ${product.category}
							</h5>
							<p class="card-text">${product.username}</p>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Functionality:
								${product.functionality}</li>
							<li class="list-group-item">Performance:
								${product.performance}</li>
							<li class="list-group-item">Usability: ${product.usability}</li>
							<li class="list-group-item">Cost: ${product.cost}</li>
							<li class="list-group-item">Value: ${product.value}</li>
							<li class="list-group-item">Customer Feedback:<br>
								${product.customerFeedback}
							</li>
							<li class="list-group-item">Environmental Feedback:<br>
								${product.environmentalFeedback}
							</li>
						</ul>
						<div class="card-body dis">
							<form action="ProductController" method="post">
								<input type="hidden" name="action" value="generateReport" /> <input
									type="hidden" name="productId" value="${product.id}" />
								<button type="submit" class="btn btn-primary">Generate
									Report</button>
							</form>
							<form action="product?action=update" method="post">
								<input type="hidden" name="action" value="update" /> <input
									type="hidden" name="id" value="${product.id}" /> <input
									type="hidden" name="username" value="${product.username}" />
								<button type="submit" class="btn btn-primary">Edit</button>
							</form>
							<form method="post" action="product?action=deleteProduct">
								<input type="hidden" name="action" value="deleteProduct" /> <input
									type="hidden" name="productId" value="${product.id}" /> <input
									type="hidden" name="username" value="${product.username}" />
								<button type="submit" class="btn btn-danger">Delete</button>
							</form>

						</div>
					</div>


				</c:forEach>

			</div>
		</div>
	</div>
</body>
</html>




