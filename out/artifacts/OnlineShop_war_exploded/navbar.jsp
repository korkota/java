<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="edu.etu.web.UTF8Control" %>
<!-- Static navbar -->
<%

    String localeName = request.getParameter("locale");

    if (localeName == null) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("locale")) {
                localeName = cookie.getValue();
                break;
            }
        }
    } else {
        Cookie cookie = new Cookie("locale", localeName);
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }

    Locale locale;

    if (localeName != null && localeName.equals("en_US")) {
        locale = new Locale("en", "US");
    } else if (localeName != null && localeName.equals("ge_GE")) {
        locale = new Locale("ge", "GE");
    } else {
        locale = new Locale("ru", "RU");
    }

    ResourceBundle internationalization = ResourceBundle.getBundle("internationalization", locale, new UTF8Control());

    request.setAttribute("internationalization", internationalization);
%>
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
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active">
                    <a href="#" class="dropdown-toggle"
                       data-toggle="dropdown"><%=internationalization.getString("language")%> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a onclick="setLocale('en_US');"><%=internationalization.getString("english")%>
                        </a></li>
                        <li><a onclick="setLocale('ru_RU');"><%=internationalization.getString("russian")%>
                        </a></li>
                        <li><a onclick="setLocale('ge_GE');"><%=internationalization.getString("german")%>
                        </a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <button class="btn btn-default"><%=internationalization.getString("signIn")%></button>
                <button class="btn btn-default"><%=internationalization.getString("cart")%></button>
                <button class="btn btn-default"><%=internationalization.getString("purchaseHistory")%></button>
            </form>
        </div>
        <!--/.nav-collapse -->
    </div>
    <!--/.container-fluid -->
</nav>
<script>
    function setLocale(locale) {
        setCookie("locale", locale, {expires: 3600});
        document.location.reload(true);
    }

    function setCookie(name, value, options) {
        options = options || {};

        var expires = options.expires;

        if (typeof expires == "number" && expires) {
            var d = new Date();
            d.setTime(d.getTime() + expires*1000);
            expires = options.expires = d;
        }
        if (expires && expires.toUTCString) {
            options.expires = expires.toUTCString();
        }

        value = encodeURIComponent(value);

        var updatedCookie = name + "=" + value;

        for(var propName in options) {
            updatedCookie += "; " + propName;
            var propValue = options[propName];
            if (propValue !== true) {
                updatedCookie += "=" + propValue;
            }
        }

        document.cookie = updatedCookie;
    }
</script>