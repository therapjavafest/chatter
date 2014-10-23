<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>

<body>

    <span>${success}</span>

    <form action="<c:url value="/login"/>" method="post">

        <label for="email">Email</label>
        <input id="email" name="email" type="text">
        <span>${emailError}</span><br/>
        <label for="password">Password</label>
        <input id="password" name="password" type="password">
         <span>${passwordError}</span>
        <br/>
        <input type="submit" value="Login">
    </form>
</body>
</html>
