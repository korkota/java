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

    <jsp:useBean id="review" class="edu.etu.web.Review" scope="session"/>
</head>
<body>
<div class="container">
    <%@ include file="navbar.jsp" %>

    <div class="col-xs-12">
        <div class="row">
            <i id="time" class="pull-right"></i>
            <strong><fmt:message key="username"/>:</strong> <c:out value="${pageContext.request.userPrincipal.name}" /><br>
            <strong><fmt:message key="defaultTab"/>:</strong> <fmt:message key="${initParam.defaultTab}"/>
        </div>
        <div class="row">
            <hr>
            <h2>Отзывы:</h2>
            <div id="reviews">
                <c:forEach items="${review.reviews}" var="review">
                    <p class="well">${review.date} <b>${review.userId}</b>: <i>${review.message}</i><br></p>
                </c:forEach>
            </div>
        </div>
        <div class="row">
            <textarea id="message" rows="10" maxlength="500" class="form-control"></textarea>
            <a class="btn btn-success pull-right" id="sendMessage">Отправить</a>
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
<script src="/assets/javascripts/moment-with-locales.min.js"></script>
<script>
    var locale = (getCookie("locale")) ? getCookie("locale").split('_')[0].toLowerCase() : 'ru';
    if (locale === "ge") locale = "de";
    moment.lang(locale);

    $(function () {
        $('#time').text(moment().format('LLL'));

        setInterval(function () {
            $('#time').text(moment().format('LLL'));
        }, 1000);

        $('#sendMessage').click(function () {
            var message = $('#message').val();

            if (message) {
                $.post('/do-review', {message: $('#message').val()}).done(function () {
                    $('#message').val('');
                    $('#reviews').append('<p class="well">' + moment().format('YYYY-MM-DD') + ' <b><c:out value="${pageContext.request.userPrincipal.name}" /></b>: <i>' + message + '</i><br></p>');
                });
            }
        });
    });
</script>
</body>
</html>
