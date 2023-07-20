<%@page import="com.register.Registration"%>
<%@ page import="java.util.List" %>
<%@ page import="com.register.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center">User Details</h1>
        <table class="table mt-5">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Full Name</th>
                    <th>Type</th>
                </tr>
                <div class="text-end mb-3">
                <br>
                <a href="AdminWelcome.jsp" class="btn btn-primary">Back</a>
    <a href="UserRegisteration.jsp" class="btn btn-primary">Add User</a>
</div>
<br>
            </thead>
            <tbody>
                <% 
                RegistrationDAO dao = new RegistrationDAO();
                List<Registration> userList = dao.getAllUsers();
                for (Registration user : userList) {
                %>
                <tr>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getFullName() %></td>
                    <td><%= user.getType() %></td>
                    <td><form action="userControl" method="post">
                    <label for="role">Change Role:</label>
        <select name="role">
            <option value="user">User</option>
            <option value="admin">Admin</option>
            <option value="analyst">Analyst</option>
        </select>

        <!-- Hidden input for user ID -->
        <input type="hidden" name="action" value="updateRole">
        <input type="hidden" name="usernameChange" value="<%= user.getUsername() %>">

        <!-- Submit button to change role -->
        <button type="submit">Change Role</button>
                        </form></td>
                    <td><form action="userControl" method="get">
    <input type="hidden" name="deleteUser" value="<%= user.getUsername() %>">
    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
</form>
                    
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
