<!-- Static navbar -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty cookie.locale.value}">
    <fmt:setLocale value="ru_RU" />
</c:if>
<c:if test="${cookie.locale.value eq 'ru_RU'}">
    <fmt:setLocale value="ru_RU" />
</c:if>
<c:if test="${cookie.locale.value eq 'ge_GE'}">
    <fmt:setLocale value="ge_GE" />
</c:if>
<c:if test="${cookie.locale.value eq 'en_US'}">
    <fmt:setLocale value="en_US" />
</c:if>

<fmt:setBundle basename="internationalization" scope="session"/>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Shop</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a>
                        <c:if test="${not empty pageContext.request.userPrincipal}">
                            <strong><fmt:message key="username"/>:</strong> <c:out value="${pageContext.request.userPrincipal.name}" />
                        </c:if>
                    </a>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active">
                    <a href="#" class="dropdown-toggle"
                       data-toggle="dropdown"><fmt:message key="language"/> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a onclick="setLocale('en_US');"><fmt:message key="english"/>
                        </a></li>
                        <li><a onclick="setLocale('ru_RU');"><fmt:message key="russian"/>
                        </a></li>
                        <li><a onclick="setLocale('ge_GE');"><fmt:message key="german"/>
                        </a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <c:if test="${empty pageContext.request.userPrincipal}">
                    <a href="/login.jsp" class="btn btn-default"><fmt:message key="signIn"/></a>
                </c:if>
                <c:if test="${not empty pageContext.request.userPrincipal}">
                    <a class="btn btn-default" href="/cart.jsp"><fmt:message key="cart"/></a>
                    <a class="btn btn-default"><fmt:message key="purchaseHistory"/></a>
                    <a class="btn btn-default" href="/personal-area.jsp"><fmt:message key="personalArea"/></a>
                    <a href="/logout.jsp" class="btn btn-default"><fmt:message key="signOut"/></a>
                </c:if>
            </form>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
</nav>