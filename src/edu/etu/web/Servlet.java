package edu.etu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
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
        Locale locale;

        if (localeName.equals("en_US")) {
            locale = new Locale("en", "US");
        } else {
            locale = new Locale("ru", "ru");
        }

        ResourceBundle internationalization = ResourceBundle.getBundle("internationalization", locale, new UTF8Control());

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
                "    <title>Navbar Template for Bootstrap</title>\n" +
                "\n" +
                "    <!-- Bootstrap core CSS -->\n" +
                "    <link href=\"/assets/stylesheets/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <link href=\"/assets/stylesheets/navbar.css\" rel=\"stylesheet\">\n" +
                "    <link href=\"/assets/stylesheets/custom.css\" rel=\"stylesheet\">\n" +
                "\n" +
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
                "            <a class=\"navbar-brand\" href=\"#\">Project name</a>\n" +
                "          </div>\n" +
                "          <div id=\"navbar\" class=\"navbar-collapse collapse\">\n" +
                "            <ul class=\"nav navbar-nav\">\n" +
                "            </ul>\n" +
                "            <ul class=\"nav navbar-nav navbar-right\">\n" +
                "                <li class=\"dropdown active\">\n" +
                "                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">" + internationalization.getString("language") + " <b class=\"caret\"></b></a>\n" +
                "                    <ul class=\"dropdown-menu\">\n" +
                "                        <li><a href=\"?locale=en_US\">" + internationalization.getString("english") + "</a></li>\n" +
                "                        <li><a href=\"?locale=ru_RU\">" + internationalization.getString("russian") + "</a></li>\n" +
                "                    </ul>\n" +
                "                </li>" +
                "            </ul>\n" +
                "          </div><!--/.nav-collapse -->\n" +
                "        </div><!--/.container-fluid -->\n" +
                "      </nav>\n" +
                "\n" +
                "    <h4>" + internationalization.getString("item") + " <small>2000$</small></h4>" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-xs-12 col-md-3\">\n" +
                "            <div class=\"text-center\">\n" +
                "                <img class=\"item img-responsive img-thumbnail\" src=\"/assets/images/item.jpg\" alt=\"\"/>\n" +
                "            </div>\n" +
                "            <br/>\n" +
                "            <button type=\"button\" class=\"btn btn-block btn-primary\">" + internationalization.getString("buy") + "</button>\n" +
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
                            "    <div role=\"tabpanel\" class=\"tab-pane\" id=\"briefDescription\">Краткое описание</div>\n" +
                            "    <div role=\"tabpanel\" class=\"tab-pane\" id=\"fullDescription\">Полное описание</div>\n" +
                            "    <div role=\"tabpanel\" class=\"tab-pane\" id=\"reviews\">Отзывы</div>\n" +
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
                "    <script src=\"/assets/javascripts/custom.js\"></script>\n" +
                "   " +
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
