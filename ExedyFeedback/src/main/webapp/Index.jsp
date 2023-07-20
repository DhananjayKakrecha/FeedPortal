<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>Exedy</title>

</head>
<body>
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
						<li>


							<form action="display">
								<button type="submit" class="btn btn-outline-primary">
									<img src="./images/grid.svg" alt="" width="24" height="24">&nbsp;&nbsp;View
									ProFeedbacks
								</button>
							</form>

						</li>
						<li><a href="./Login.jsp" class="nav-link text-dark"> <img
								src="./images/person-circle.svg" alt="" width="24" height="24">
								Admin
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>

	<div class="container col-xxl-8 px-4 py-5">
		<div class="row flex-lg-row-reverse align-items-center g-5 py-5">
			<div class="col-10 col-sm-8 col-lg-6">
				<img src="./images/exedylogo.jpeg"
					class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes"
					width="500" height="200" loading="lazy"
					style="border-radius: 50% !important;">
			</div>
			<div class="col-lg-6">
				<h1 class="display-5 fw-bold text-body-emphasis lh-1 mb-3">Excellent
					and Dynamic</h1>
				<p class="lead">The leading company for drivetrain components.</p>
				<div class="d-grid gap-2 d-md-flex justify-content-md-start">
					<button type="button" class="btn btn-primary btn-lg px-4 me-md-2">
						<a href="./Login.jsp" style="text-decoration: none; color: white;">Login</a>
					</button>
					<button type="button" class="btn btn-outline-secondary btn-lg px-4">
						<a href="./UserRegistration.jsp"
							style="text-decoration: none; ">Register</a>
					</button>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>