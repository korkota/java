package edu.etu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by korkota on 2/26/15.
 */
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String localeName = request.getParameter("locale");

        if (localeName == null) {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("locale")) {
                        localeName = cookie.getValue();
                        break;
                    }
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

        ServletContext context = getServletContext();
        Items items = (Items)context.getAttribute("items");

        String id = request.getParameter("id");
        Item item = null;
        for (Item itemCandidate : items.getItems()) {
            if (itemCandidate.id.equals(id)) {
                item = itemCandidate;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(
                "<!DOCTYPE html>" +
                "<html lang=\"ru\"><head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <meta name=\"description\" content=\"\">\n" +
                "    <meta name=\"author\" content=\"\">\n" +
                "    <link rel=\"icon\" href=\"../../favicon.ico\">\n" +
                "\n" +
                "    <title>Shop</title>\n" +
                "\n" +
                "    <!-- Bootstrap core CSS -->\n" +
                "    <link href=\"/assets/stylesheets/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <link href=\"/assets/stylesheets/navbar.css\" rel=\"stylesheet\">\n" +
                "    <link href=\"/assets/stylesheets/bootstrap-formhelpers.min.css\" rel=\"stylesheet\">\n" +
                "    <link href=\"/assets/stylesheets/custom.css\" rel=\"stylesheet\">\n" +
                "  <body>\n" +
                "\n" +
                "    <div class=\"container\">\n" +
                "\n" +
                "      <!-- Static navbar -->\n" +
                "      <nav class=\"navbar navbar-default\">\n" +
                "        <div class=\"container-fluid\">\n" +
                "          <div class=\"navbar-header\">\n" +
                "            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n" +
                "              <span class=\"sr-only\">Toggle navigation</span>\n" +
                "              <span class=\"icon-bar\"></span>\n" +
                "              <span class=\"icon-bar\"></span>\n" +
                "              <span class=\"icon-bar\"></span>\n" +
                "            </button>\n" +
                "            <a class=\"navbar-brand\" href=\"/\">Shop</a>\n" +
                "          </div>\n" +
                "          <div id=\"navbar\" class=\"navbar-collapse collapse\">\n" +
                "            <ul class=\"nav navbar-nav\">\n" +
                "            </ul>\n" +
                "            <ul class=\"nav navbar-nav navbar-right\">\n" +
                "                <li class=\"dropdown active\">\n" +
                "                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">" + internationalization.getString("language") + " <b class=\"caret\"></b></a>\n" +
                "                    <ul class=\"dropdown-menu\">\n" +
                "                        <li><a onclick=\"setLocale('en_US');\">" + internationalization.getString("english") + "</a></li>\n" +
                "                        <li><a onclick=\"setLocale('ru_RU');\">" + internationalization.getString("russian") + "</a></li>\n" +
                "                        <li><a onclick=\"setLocale('ge_GE');\">" + internationalization.getString("german") + "</a></li>\n" +
                "                    </ul>\n" +
                "                </li>" +
                "            </ul>\n" +
                "            <form class=\"navbar-form navbar-right\">\n" +
                "                <button class=\"btn btn-default\">"+ internationalization.getString("signIn") + "</button>\n" +
                "                <a class=\"btn btn-default\" href=\"/cart.jsp\">" + internationalization.getString("cart") +  "</a>\n" +
                "                <button class=\"btn btn-default\">" + internationalization.getString("purchaseHistory") +  "</button>\n" +
                "            </form>" +
                "          </div><!--/.nav-collapse -->\n" +
                "        </div><!--/.container-fluid -->\n" +
                "      </nav>\n" +
                "\n" +
                "    <h4>" + item.title + " <small>" + item.price + "$</small></h4>" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-xs-12 col-md-3\">\n" +
                "            <div class=\"text-center\">\n" +
                "                <img class=\"item img-responsive img-thumbnail\" src=\"/assets/images/items/" + item.id + ".jpg\" alt=\"\"/>\n" +
                "            </div>\n" +
                "            <br/>\n" +
                "            <form class=\"form-inline\" action=\"/add-item-to-cart\" method=\"POST\">\n" +
                "                <div class=\"form-group\">\n" +
                "                    <input type=\"hidden\" class=\"form-control\" name=\"id\" value=\""+ item.id +"\"/>\n" +
                "                </div>\n" +
                "                <div class=\"form-group col-xs-8\">\n" +
                "                    <input type=\"text\" name=\"count\" class=\"form-control bfh-number\" data-min=\"1\" data-max=\"25\">\n" +
                "                </div>\n" +
                "                <div class=\"form-group col-xs-4\">\n" +
                "                    <input type=\"submit\" class=\"form-control btn btn-primary\" value=\"" + internationalization.getString("buy") + "\" />\n" +
                "                </div>\n" +
                "            </form>" +
                "        </div>\n" +
                "        <div class=\"col-xs-12 col-md-9\">\n" +
                            "<div id=\"description\" role=\"tabpanel\">\n" +
                            "\n" +
                            "  <!-- Nav tabs -->\n" +
                            "  <ul class=\"nav nav-tabs\" role=\"tablist\">\n" +
                            "    <li role=\"presentation\"><a href=\"#briefDescription\" aria-controls=\"home\" role=\"tab\" data-toggle=\"tab\">" + internationalization.getString("briefDescription") + "</a></li>\n" +
                            "    <li role=\"presentation\"><a href=\"#fullDescription\" aria-controls=\"profile\" role=\"tab\" data-toggle=\"tab\">" + internationalization.getString("fullDescription") + "</a></li>\n" +
                            "    <li role=\"presentation\"><a href=\"#reviews\" aria-controls=\"messages\" role=\"tab\" data-toggle=\"tab\">" + internationalization.getString("reviews") + "</a></li>\n" +
                            "  </ul>\n" +
                            "\n" +
                            "  <!-- Tab panes -->\n" +
                            "  <div class=\"tab-content\">\n" +
                            "    <div role=\"tabpanel\" class=\"tab-pane\" id=\"briefDescription\">"
                                    + item.briefDescription +
                                "</div>\n" +
                            "    <div role=\"tabpanel\" class=\"tab-pane\" id=\"fullDescription\">"
                                    + item.fullDescription +
                                "</div>\n" +
                            "    <div role=\"tabpanel\" class=\"tab-pane\" id=\"reviews\">" +
                                    "<p class=\"well\">Отзыв от пользователя <b>User1</b>: </br>" +
                                        "<i>Отличный товар!</i>" +
                                        "</br>" +
                                    "</p>" +
                                    "<p class=\"well\">Отзыв от пользователя <b>User2</b>: </br>" +
                                        "<i>Слишком дорогой товар. Можной найти дешевле в других магазинах.</i>" +
                                    "</p>" +
                                "</div>\n" +
                            "  </div>\n" +
                            "\n" +
                            "</div>" +
                "        </div>\n" +
                "    </div>" +
                "\n" +
                "    </div> <!-- /container -->\n" +
                "\n" +
                "\n" +
                "    <script> var CONFIG = {defaultTab: '" + getInitParameter("defaultTab") + "'}; </script>" +
                "    <!-- Bootstrap core JavaScript\n" +
                "    ================================================== -->\n" +
                "    <!-- Placed at the end of the document so the pages load faster -->\n" +
                "    <script src=\"/assets/javascripts/jquery.min.js\"></script>\n" +
                "    <script src=\"/assets/javascripts/bootstrap.js\"></script>\n" +
                    "<script src=\"/assets/javascripts/bootstrap-formhelpers.js\"></script>" +
                "    <script src=\"/assets/javascripts/custom.js\"></script>\n" +
                "   " +
                " " +
                "\n" +
                "</body></html>"
        );

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println(sb.toString());

        out.close();
    }
}
