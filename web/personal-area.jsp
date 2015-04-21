<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Shop</title>
    <!-- Bootstrap core CSS -->
    <link href="/assets/stylesheets/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/stylesheets/navbar.css" rel="stylesheet">
    <link href="/assets/stylesheets/custom.css" rel="stylesheet">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

</head>
<body>
<div class="container">
    <%@ include file="navbar.jsp" %>

    <div class="col-xs-12">
        <div class="row">
            <strong><fmt:message key="username"/>:</strong> <c:out value="${pageContext.request.userPrincipal.name}" /><br>
            <strong><fmt:message key="defaultTab"/>:</strong> <fmt:message key="${initParam.defaultTab}"/>
        </div>
    </div>
</div>
<!-- /container -->


<!-- Bootstrap core JavaScript
              ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/assets/javascripts/jquery.min.js"></script>
<script src="/assets/javascripts/bootstrap.js"></script>
<script src="/assets/javascripts/custom.js"></script>
</body>
</html>
