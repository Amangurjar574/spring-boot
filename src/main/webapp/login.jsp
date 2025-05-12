<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login Page</h2>

    <form method="post" action="/loginapi">
        <label>Username:</label>
        <input type="text" name="name" required /><br><br>

        <label>Password:</label>
        <input type="password" name="password" required /><br><br>

        <button type="submit">Login</button>
    </form>

    <%
        String error = request.getParameter("error");
        if (error != null) {
    %>
        <p style="color:red;">Invalid username or password!</p>
    <%
        }
    %>
</body>
</html>
