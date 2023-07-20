<%@page import="com.product.ProductRegistration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form class="row g-3" action="update" method="post">
			<div class="col-12">
				<label for="productId" class="form-label">Product ID:</label> <input
					type="text" class="form-control" id="pid" name="productId" value="${product.id}" required>
			</div>
			<div class="col-md-6">
				<label for="functionality" class="form-label">Functionality</label>
				<input type="number" class="form-control" id="functionality"
					name="functionality" min="0" max="10" value="${product.functionality }" required>
			</div>
			<div class="col-md-6">
				<label for="performance" class="form-label">Performance</label> <input
					type="number" class="form-control" id="performance"
					name="performance" min="0" max="10" value="${product.performance}" required>
			</div>
			<div class="col-md-6">
				<label for="usability" class="form-label">Usability</label> <input
					type="number" class="form-control" id="usability" name="usability" value="${product.usability}"
					min="0" max="10" required>
			</div>
			<div class="col-md-6">
				<label for="cost" class="form-label">Cost</label> <input
					type="number" class="form-control" id="cost" name="cost" min="0"
					max="10" value="${product.cost}" required>
			</div>
			<div class="col-md-6">
				<label for="value" class="form-label">Value</label> <input
					type="number" class="form-control" id="value" name="value" min="0"
					max="10" value="${product.value}" required>
			</div>
			<div class="col-md-6">
				<label for="category" class="form-label">Category</label> <select
					id="category" name="category" class="form-select" required>
					<option selected>${product.category}</option>
					<option value="Category 2">Category 2</option>
					<option value="Category 3">Category 3</option>
				</select>
			</div>


			<div class="col-md-12">
				<label for="customerFeedback">Customer Feedback:</label><br>
				<textarea class="form-control" placeholder="${product.customerFeedback}"
					id="customerFeedback" name="customerFeedback" style="height: 100px" required>${product.customerFeedback}</textarea>
			</div>

			<div class="col-md-12">
				<label for="environmentalFeedback">Environmental Impact:</label><br>
				<textarea class="form-control" placeholder="${product.environmentalImpact}"
					id="environmentalFeedback" name="environmentalFeedback"
					style="height: 100px" required>${product.environmentalImpact}</textarea>
			</div>
			<div class="col-12">
				<input type="hidden" name="action" value="updateFeed">
				<button type="submit" class="btn btn-primary" id="updateBtn" name="updateBtn">Update
					Feedback</button>
			</div>
		</form>
	</div>
</body>
</html>