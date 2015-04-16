<%@ page import="edu.etu.web.Item" %>
<%--
  Created by IntelliJ IDEA.
  User: korkota
  Date: 2/25/15
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="/assets/stylesheets/bootstrap-formhelpers.min.css" rel="stylesheet">
    <link href="/assets/stylesheets/navbar.css" rel="stylesheet">
    <link href="/assets/stylesheets/custom.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>
<div class="container">
    <%@ include file="/navbar.jsp" %>
    <div class="row">
        <div class="col-xs-12">
            <form class="form-signin form-horizontal" action="j_security_check" method="post" name="loginForm">
                <div class="form-group">
                    <div class="alert alert-warning text-center" role="alert"><fmt:message key="signInError"/></div>

                    <label for="inputEmail" class="col-sm-4 control-label"><fmt:message key="username"/>:</label>

                    <div class="col-sm-8">
                        <input id="inputEmail" name="j_username" type="text" class="form-control" size="20" required=""
                               autofocus=""><br>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-4 control-label"><fmt:message key="password"/>:</label>

                    <div class="col-sm-8">
                        <input type="password" name="j_password" id="inputPassword" class="form-control" size="20"
                               required=""><br>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <button class="btn btn-primary" type="submit"><fmt:message key="signIn"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- /container -->


<!-- Bootstrap core JavaScript
              ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/assets/javascripts/jquery.min.js"></script>
<script src="/assets/javascripts/bootstrap.js"></script>
<script src="/assets/javascripts/bootstrap-formhelpers.js"></script>
<script src="/assets/javascripts/custom.js"></script>
</body>
</html>