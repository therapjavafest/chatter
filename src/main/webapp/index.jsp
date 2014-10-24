<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8" />
<title>Home :: Chatter</title>

    <jsp:include page="WEB-INF/views/fragments/headTag.jsp"/>

</head>
<body>
    <div class="container">
       <jsp:include page="WEB-INF/views/fragments/bodyHeader.jsp"/>

        <div class="jumbotron">
            <h1>Hello world</h1>
            <p class="lead">This is going to be a clone application of twitter!!</p>

            <p><a class="btn btn-lg btn-success" href="<c:url value="/register"/>" role="button">Sign up today</a></p>
        </div>

        <div class="row marketing">
            <div class="col-lg-6">
                <h4>Subheading</h4>
                <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

                <h4>Subheading</h4>
                <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

                <h4>Subheading</h4>
                <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
            </div>

            <div class="col-lg-6">
                <h4>Subheading</h4>
                <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

                <h4>Subheading</h4>
                <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

                <h4>Subheading</h4>
                <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
            </div>
        </div>

        <jsp:include page="WEB-INF/views/fragments/footer.jsp"/>
    </div> <!-- /container -->
</body>
</html>