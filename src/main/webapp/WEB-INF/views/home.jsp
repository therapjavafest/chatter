<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home :: Chatter</title>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <form class="form" role="form" action="<c:url value='/home'/>" method="post">
        <div class="form-group">
            <label for="chatter">Chatter</label><br/>
            <textarea id="chatter" name="chatter" rows="5" cols="50"></textarea>
            <span class="text-danger">${chatterError}</span>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Chatter</button>
            </div>
        </div>
    </form>

    <c:choose>
        <c:when test="${not empty chatters}">
            <div>${chatters.size()} chatters found!</div>
            <c:forEach items="${chatters}" var="chatter">
                <div id="chatter-box">
                    <div class="alert" role="alert">
                        <span><strong>${chatter.createdBy.firstName} ${chatter.createdBy.lastName} </strong> . </span>
                        <span class="text-primary"><fmt:formatDate value="${chatter.created}" pattern="dd MMMMM yyyy hh:mm aaa"/></span><br/>
                        <span>${chatter.text}</span>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>No chatter found</c:otherwise>
    </c:choose>

    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>