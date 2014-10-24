<%@ page import="com.therapjavafest.chatter.util.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
    <ul class="nav nav-pills pull-right">
        <% if (session.getAttribute(Constants.AUTH_KEY) != null) { %>
        <li><a href="<c:url value="/home"/>">Home</a></li>
        <% }%>
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
        <% if (session.getAttribute(Constants.AUTH_KEY) != null) { %>
        <li><a href="<c:url value="/logout" />">Logout</a></li>
        <% } else { %>
        <li><a href="<c:url value="/login" />">Login</a></li>
        <% }%>
    </ul>
    <h3 class="text-muted"><a href="<c:url value="/"/>">Chatter</a> </h3>
</div>
