<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>

<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <div class="row">
        <span>${success}</span>
    </div>

    <div class="row">
        <fieldset>
            <legend>Sign up</legend>

            <form class="form-horizontal" role="form" action="<c:url value="/register"/>" method="post">
                <div class="form-group">
                    <label for="firstName" class="col-sm-2 control-label">First Name</label>

                    <div class="col-sm-10">
                        <input id="firstName" name="firstName" type="text">
                        <span class="text-danger">${firstNameError}</span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastName" class="col-sm-2 control-label">Last Name</label>

                    <div class="col-sm-10">
                        <input id="lastName" name="lastName" type="text">
                        <span class="text-danger">${lastNameError}</span>
                    </div>
                </div>

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
                    <label for="passwordConfirmed" class="col-sm-2 control-label">Password Confirmed</label>

                    <div class="col-sm-10">
                        <input id="passwordConfirmed" name="passwordConfirmed" type="password">
                        <span class="text-danger">${passwordConfirmedError}</span>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign Up</button>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</div>

</body>
</html>
