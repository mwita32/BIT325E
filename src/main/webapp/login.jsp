<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Login</h2>
    <form action="LoginServlet" method="post" class="w-50">
        <div class="mb-3">
            <label>Username:</label>
            <input type="text" name="username" class="form-control" required />
        </div>
        <div class="mb-3">
            <label>Password:</label>
            <input type="password" name="password" class="form-control" required />
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <p class="mt-3">Don’t have an account? <a href="register.jsp">Register</a></p>
</body>
</html>
