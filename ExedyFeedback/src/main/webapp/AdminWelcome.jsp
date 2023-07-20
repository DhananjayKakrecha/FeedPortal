<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Welcome</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
     <%
    String username = request.getParameter("username");
%>
        <h1 class="text-center">Admin Welcome ${username}</h1>
  
        <br>
        <a href="Login.jsp" class="btn btn-primary">Logout</a>
        <br>
        <div class="row mt-5">
            <div class="col-md-4">
                <a href="UserDetails.jsp?username=${username}" class="btn btn-primary btn-lg btn-block">User Details</a>
            </div>
            <div class="col-md-4">
                <form action="adminProduct" method="post">
						<button type="submit" class="btn btn-primary btn-lg btn-block">View
							ProFeedbacks</button>
					</form>
            </div>
            <div class="col-md-4">
                <a href="./AdminRegistration.jsp" class="btn btn-primary btn-lg btn-block">Register Admin</a>

            </div>
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    