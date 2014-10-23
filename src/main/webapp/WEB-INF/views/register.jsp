<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<span>${success}</span>

<form action="<c:url value="/register"/>" method="post">

    <label for="firstName">First Name</label>
    <input id="firstName" name="firstName" type="text">
    <span>${firstNameError}</span>
    <br/>

    <label for="lastName">Last Name</label>
    <input id="lastName" name="lastName" type="text">
    <span>${lastNameError}</span>

    <br/>

    <label for="email">Email</label>
    <input id="email" name="email" type="text">
    <span>${emailError}</span>
    <br/>

    <label for="password">Password</label>
    <input id="password" name="password" type="password">
    <span>${passwordError}</span>
    <br/>

    <label for="passwordConfirmed">Password Confirmed</label>
    <input id="passwordConfirmed" name="passwordConfirmed" type="password">
    <span>${passwordConfirmedError}</span>
    <br/>

    <input type="submit" value="Register">
</form>

</body>
</html>
