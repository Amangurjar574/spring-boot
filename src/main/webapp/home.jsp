<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="create" method="post">
        <label for="id">ID:</label>
        <input type="number" name="id" required><br><br>

        <label for="name">Name:</label>
        <input type="text" name="name" required><br><br>

        <label for="password">Password:</label>
        <input type="password" name="password" required><br><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>
