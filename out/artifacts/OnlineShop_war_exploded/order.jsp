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

    <jsp:useBean id="markets" class="edu.etu.web.Markets" scope="application"/>
</head>
<body>
<div class="container">
    <%@ include file="navbar.jsp" %>

    <div class="col-xs-12">
        <div class="row">
            <div role="tabpanel" id="description">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#market" aria-controls="market" role="tab" data-toggle="tab">Самовывоз</a></li>
                    <li role="presentation"><a href="#address" aria-controls="address" role="tab" data-toggle="tab">Доставка курьером</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="market">
                        Самовывоз
                        <form class="form-inline" action="/do-order" method="POST">
                            <div class="form-group col-xs-4">
                                <select class="form-control" name="marketId" value="${market.id}">
                                    <c:forEach items="${markets.markets}" var="market">
                                        <option value="${market.id}">${market.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-xs-4">
                                <fmt:message key="order" var="order"/>
                                <input type="submit" class="form-control btn btn-primary" value="${order}" />
                            </div>
                        </form>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="address">Доставка курьером</div>
                </div>
            </div>
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
