<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<%
	String username = request.getParameter("username");
	%>
	<div class="container">
		<form class="row g-3"
			action="prodcut?action=addProduct&username=${username}"
			method="post">
			<div>
				<h2 class="mb-4">Give your Feedback!</h2>
			</div>
			<div class="col-md-6">
				<label for="functionality" class="form-label">Functionality</label>
				<input type="number" class="form-control" id="functionality"
					name="functionality" min="0" max="10" required>
			</div>
			<div class="col-md-6">
				<label for="performance" class="form-label">Performance</label> <input
					type="number" class="form-control" id="performance"
					name="performance" min="0" max="10" required>
			</div>
			<div class="col-md-6">
				<label for="usability" class="form-label">Usability</label> <input
					type="number" class="form-control" id="usability" name="usability"
					min="0" max="10" required>
			</div>
			<div class="col-md-6">
				<label for="cost" class="form-label">Cost</label> <input
					type="number" class="form-control" id="cost" name="cost" min="0"
					max="10" required>
			</div>
			<div class="col-md-6">
				<label for="value" class="form-label">Value</label> <input
					type="number" class="form-control" id="value" name="value" min="0"
					max="10" required>
			</div>
			<div class="col-md-6">
				<label for="category" class="form-label">Category</label> <select
					id="category" name="category" class="form-select" required>
					<option value="Category 1">Category 1</option>
					<option value="Category 2">Category 2</option>
					<option value="Category 3">Category 3</option>
				</select>
			</div>


			<div class="col-md-12">
				<label for="customerFeedback">Customer Feedback:</label><br>
				<textarea class="form-control" placeholder="Leave a comment here"
					id="customerFeedback" name="customerFeedback" style="height: 100px"
					required></textarea>
			</div>

			<div class="col-md-12">
				<label for="environmentalFeedback">Environmental Feedback:</label><br>
				<textarea class="form-control" placeholder="Leave a comment here"
					id="environmentalFeedback" name="environmentalFeedback"
					style="height: 100px" required></textarea>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>

</body>
</html>
