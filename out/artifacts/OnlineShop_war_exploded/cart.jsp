<%@ page import="edu.etu.web.Item" %>
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

    <jsp:useBean id="items" class="edu.etu.web.Items" scope="application"/>
    <jsp:useBean id="cart" class="edu.etu.web.Cart" scope="session"/>
</head>
<body>
<div class="container">
    <%@ include file="navbar.jsp" %>

    <div class="row">
        <div class="col-xs-12">
            <c:forEach items="${cart.getCart()}" var="item">
                <div class="well">
                <h4><a href="/items?id=${item.key.id}">${item.key.title}</a></h4>
                <div class="row">
                    <div class="col-xs-12 col-md-4">
                        <div class="text-center">
                            <img class="item img-responsive img-thumbnail" src="/assets/images/items/${item.key.id}.jpg" alt=""/>
                        </div>
                        <br/>
                        <div class="alert alert-info text-center" role="alert">
                            <strong>${item.key.price}$ х ${item.value} = ${item.value * item.key.price}$</strong>
                        </div>
                        <form action="/remove-item-from-cart" method="POST">
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="id" value="${item.key.id}"/>
                            </div>
                            <div class="form-group">
                                <fmt:message key="delete" var="delete"/>
                                <input type="submit" class="form-control btn btn-danger" value="${delete}" />
                            </div>
                        </form>
                    </div>
                    <div class="col-xs-12 col-md-8">
                        ${item.key.briefDescription}
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
        <div class="col-xs-12">
            <c:choose>
                <c:when test="${cart.getCart().isEmpty()}">
                    <fmt:message key="emptyCart" />
                </c:when>
                <c:otherwise>
                    <div class="col-sm-4">
                        <h4 class="text-center">
                            <fmt:message key="total" />: ${cart.getTotalSum()}$
                        </h4>
                    </div>
                </c:otherwise>
            </c:choose>
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
