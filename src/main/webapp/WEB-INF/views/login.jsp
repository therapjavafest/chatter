<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="fragments/headTag.jsp"/>
</head>

<body>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <div class="row">
        <span class="alert-info">${success}</span>
    </div>

    <fieldset>
        <legend>Login</legend>

        <form class="form-horizontal" role="form" action="<c:url value="/login"/>" method="post">

            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email</label>

                <div class="col-sm-10">
                    <input id="email" name="email" type="text">
                    <span class="text-danger">${emailError}</span>
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>

                <div class="col-sm-10">
                    <input id="password" name="password" type="password">
                    <span class="text-danger">${passwordError}</span>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Login</button>
                </div>
            </div>

        </form>
    </fieldset>

    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>
