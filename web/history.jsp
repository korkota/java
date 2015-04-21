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

    <jsp:useBean id="history" class="edu.etu.web.History" scope="session"/>
</head>
<body>
<div class="container">
    <%@ include file="navbar.jsp" %>

    <div class="col-xs-12">
        <div class="row">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th><fmt:message key="item"/></th>
                    <th><fmt:message key="amount"/></th>
                    <th><fmt:message key="deliveryAddress"/></th>
                    <th><fmt:message key="date"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${history.history}" var="history">
                    <tr>
                        <th scope="row">${history.item_title}</th>
                        <td>${history.item_count}</td>
                        <td>${empty history.delivery_address ? history.market_address : history.delivery_address}</td>
                        <td>${history.date}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr>
            <span class="pull-right"><fmt:message key="theTotalNumberOfOrders"/>: <strong>${history.history.size()}</strong></span>
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
