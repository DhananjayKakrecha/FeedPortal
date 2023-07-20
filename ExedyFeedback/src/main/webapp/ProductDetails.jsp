<%@page import="com.product.ProductRegistrationDAO"%>
<%@page import="com.product.ProductRegistration"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	// Get the logged-in username from your authentication or session management mechanism
    String loggedInUsername = (String) request.getSession().getAttribute("username"); // Replace with your implementation
    loggedInUsername.strip();
	%>
	<header>
		<div class="px-3 py-2 border-bottom">
			<div class="container-fluid">
				<div
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
					<a href="./index.html"
						class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none ms-3">
						<img src="./images/box-fill.svg" alt="" height="30"> <span
						class="fs-2 ps-3 text-dark">Exedy</span>
					</a>

					<ul
						class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
						<li><a href="./Index.jsp" class="nav-link text-dark"> <img
								src="./images/house-door.svg" alt="" width="24" height="24">
								Home
						</a></li>
						<li><a href="./ProFeedback.jsp?username=${username}"
							class="nav-link text-dark"> <img
								src="./images/calendar2-plus.svg" alt="" width="24" height="24">
								Add Feedback
						</a></li>
						<li>


							<form action="display">
								<button type="submit" class="btn btn-outline-primary">
									<img src="./images/grid.svg" alt="" width="24" height="24">&nbsp;&nbsp;View
									ProFeedbacks
								</button>
							</form>

						</li>
						<li><a href="/" class="nav-link text-dark"> <img
								src="./images/person-circle.svg" alt="" width="24" height="24">
								${username}
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="card-group">
			<div class="row">

				<%
				ProductRegistrationDAO dao = new ProductRegistrationDAO();
				List<ProductRegistration> product = dao.getAllProduct(loggedInUsername);
				for (ProductRegistration products : product) {
				%>

				<div class="card" style="width: 18rem;">
					<img src="./images/person-circle.svg" height="100"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">
							ProFeedback Id: <%= products.getId() %> <br> <%= products.getCategory() %> 
						</h5>
						<p class="card-text"><%= products.getUsername() %></p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Functionality:
							<%= products.getFunctionality() %></li>
						<li class="list-group-item">Performance:
							<%= products.getPerformance() %></li>
						<li class="list-group-item">Usability: <%= products.getUsability() %></li>
						<li class="list-group-item">Cost: <%= products.getCost() %></li>
						<li class="list-group-item">Value:<%= products.getValue() %></li>
						<li class="list-group-item">Customer Feedback:<br>
							<%= products.getCustomerFeedback() %>
						</li>
						<li class="list-group-item">Environmental Impact:<br>
							<%= products.getEnvironmentalImpact() %>
						</li>
					</ul>
					<div class="card-body dis">
						<form action="userControl" method="post">
							<input type="hidden" name="username" value="<%= products.getUsername() %>">
							<input type="hidden" name="action" value="generateReport" /> <input
								type="hidden" name="productId" value="<%= products.getId() %>" />
							<button type="submit" class="btn btn-primary">Generate
								Report</button>
						</form>
						<form action="update" method="post">
							<input type="hidden" name="action" value="update" /> <input
								type="hidden" name="id" value="<%= products.getId() %>" /> <input
								type="hidden" name="username" value="<%= products.getUsername() %>" />
							<button type="submit" class="btn btn-primary">Edit</button>
						</form>
						<form method="post" action="deleteFeed">
							<input type="hidden" name="action" value="deleteProduct" /> <input
								type="hidden" name="productId" value="<%= products.getId() %>" /> <input
								type="hidden" name="username" value="<%= products.getUsername() %>" />
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>

					</div>
				</div>

				<%
				}
				%>


			</div>
		</div>
	</div>
</body>
</html>




