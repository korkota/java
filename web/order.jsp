<%@ page pageEncoding="UTF-8" %>
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
            <h3><fmt:message key="selectDeliveryMethod"/>:</h3>
            <div role="tabpanel" id="description">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#market" aria-controls="market" role="tab" data-toggle="tab"><fmt:message key="pickup"/></a></li>
                    <li role="presentation"><a href="#address" aria-controls="address" role="tab" data-toggle="tab"><fmt:message key="deliveryByCourier"/></a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="market">
                        <div id="map" class="map"></div>
                        <br>
                        <form class="form-inline pull-right" action="/do-order" method="POST">
                            <div class="form-group">
                                <label for="marketId" class="control-label"><fmt:message key="deliveryAddress"/>:</label>
                                    <select class="form-control" name="marketId" id="marketId" value="${market.id}">
                                        <c:forEach items="${markets.markets}" var="market">
                                            <option value="${market.id}">${market.name}</option>
                                        </c:forEach>
                                    </select>
                            </div>

                            <div class="form-group">
                                <fmt:message key="order" var="order"/>
                                <input type="submit" class="form-control btn btn-primary btn-block" value="${order}" />
                            </div>
                        </form>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="address">
                        <form class="form-horizontal" action="/do-order" method="POST">
                            <div class="form-group col-xs-8">
                                <label for="deliveryAddress" class="col-xs-4 control-label"><fmt:message key="deliveryAddress"/>:</label>
                                <div class="col-xs-8">
                                    <input type="text" pattern=".{5,150}" class="form-control" id="deliveryAddress" name="address"/>
                                </div>
                            </div>

                            <div class="form-group col-xs-4">
                                <fmt:message key="order" var="order"/>
                                <input type="submit" class="form-control btn btn-primary btn-block" value="${order}" />
                            </div>
                        </form>
                    </div>
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
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script src="/assets/javascripts/gmaps.js"></script>
<script>
    $(function () {
        var map = new GMaps({
            div: '#map',
            lat: 59.9423031,
            lng: 30.3484035,
            zoom: 12
        });

        <c:forEach items="${markets.markets}" var="market">
            map.addMarker({
                lat: ${market.lat},
                lng: ${market.lng},
                title: '${market.name}',
                click: function(e) {
                    $('#marketId').val('${market.id}');
                },
                infoWindow: {
                    content: '<span><strong>${market.name}:</strong> ${market.address} </span>'
                }
            });
        </c:forEach>
    });
</script>
<script src="/assets/javascripts/custom.js"></script>
</body>
</html>
