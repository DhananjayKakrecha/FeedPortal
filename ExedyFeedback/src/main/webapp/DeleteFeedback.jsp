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
		<form class="row g-3" action="deleteFeed" method="post">
			<div class="col-md-6">
				<label for="productId" class="form-label">Product ID:</label> <input
					type="text" class="form-control" id="productId" name="productId" required>
			</div>

			<div class="col-12">
				<button type="submit" class="btn btn-primary">Delete Feedback</button>
			</div>

		</form>
	</div>
</body>
</html>