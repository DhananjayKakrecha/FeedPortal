<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<header
			class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
			<a href="./index.html"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<img src="./images/box-fill.svg" alt="Box" height="30"> <span
				class="fs-4 ps-2">Exedy</span>
			</a>

		</header>
	</div>
	<div class="container">
		
			<div class="card-group">
				<div class="row">
				<c:forEach var="product" items="${products}">
					<div class="card" style="width:18rem;">
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
							<li class="list-group-item">Customer Feedback: <br>
								${product.customerFeedback}
							</li>
							<li class="list-group-item">Environmental Impact: <br>
								${product.environmentalImpact}
							</li>
						</ul>
						<div class="card-body">
							<form action="userControl" method="post"> <input
								type="hidden" name="user" value="${username}">
							<input type="hidden" name="action" value="generateReport" /> <input
								type="hidden" name="productId"
								value="${product.id}" />
							<button type="submit" class="btn btn-primary">Generate
								Report</button>
							</form>
						</div>
					</div>

				</c:forEach>

			</div>
		</div>
	</div>
</body>
</html>




