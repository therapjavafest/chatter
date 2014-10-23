<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home :: Chatter</title>
</head>
<body>
    <form action="<c:url value='/home'/>" method="post">
        <label for="chatter">Chatter</label><br/>
        <textarea id="chatter" name="chatter" rows="5" cols="40"></textarea>
        <br/>
        <input type="submit" value="Chatter">
    </form>

    <c:choose>
        <c:when test="${not empty chatters}">
            <div>${chatters.size()} chatters found!</div>
            <c:forEach items="${chatters}" var="chatter">
                <div id="chatter-box">
                    <div>${chatter.text} by ${chatter.createdBy.firstName} ${chatter.createdBy.lastName} at
                        <fmt:formatDate value="${chatter.created}" pattern="dd/MM/yyyy"/>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>No chatter found</c:otherwise>
    </c:choose>
</body>
</html>