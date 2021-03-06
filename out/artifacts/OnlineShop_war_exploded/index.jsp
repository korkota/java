<%@ page import="edu.etu.web.Item" %>
<%@ page import="edu.etu.web.models.ItemEntity" %>
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
    <jsp:useBean id="items" class="edu.etu.web.Items" scope="application"/>
    <jsp:useBean id="cart" class="edu.etu.web.Cart" scope="session"/>
</head>
<body>
<div class="container">
    <%@ include file="navbar.jsp" %>
    <%
        String id = request.getParameter("id");

        if (id != null) {
            Cookie cookie = new Cookie("filter.id", id);
            cookie.setMaxAge(20); //1 hour
            response.addCookie(cookie);
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("filter.id")) {
                        id = cookie.getValue();
                        break;
                    }
                }
            }
        }
    %>
    <div class="row">
        <div class="col-xs-12">
            <form class="form-inline pull-right">
                <div class="form-group">
                    <label for="filter" class="text-right"><fmt:message key="show"/>:</label>
                    <select id="filter" class="form-control" onchange="itemsChanged();">
                        <option value="0"><fmt:message key="all"/></option>
                        <% for (ItemEntity item : items.getItems()) {
                            String selected = "";
                            if (id != null && id.equals(item.getId().toString())) {
                                selected = "selected";
                            }
                        %>
                            <option value="<%=item.getId().toString()%>" <%=selected%>>
                                <%=item.getTitle()%>
                            </option>
                        <% } %>
                    </select>
                </div>
            </form>
        </div>
    </div>
    <% for (ItemEntity item : items.getItems()) {
        if (id != null && !id.equals("0") && !id.equals(item.getId().toString())) {
            continue;
        }
        request.setAttribute("item", item);
    %>
        <jsp:include page="itemPreview.jsp" />
    <% } %>
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
