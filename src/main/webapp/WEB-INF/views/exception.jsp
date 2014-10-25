<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<jsp:include page="fragments/headTag.jsp"/>

<body>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <c:choose>
        <c:when test="${statusCode == 404}">
            Sorry, the page you requested was not found.
            <br/>
            <br/>
            <a href="<c:url value="/"/>"> Go Back</a>
        </c:when>
        <c:otherwise>
            <h2>There has been an error in processing your request.</h2>
            <br/>
            <br/>
            <a href="<c:url value="/"/>"> Go Back </a>
        </c:otherwise>
    </c:choose>

    <hr/>
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>

</html>
