package edu.etu.web;

import edu.etu.web.models.ItemEntity;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Алексей on 01.04.2015.
 */
@WebServlet(name = "AddItemToCart")
public class AddItemToCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cart cart = (Cart)session.getAttribute("cart");

        ServletContext context = getServletContext();
        Items items = (Items)context.getAttribute("items");

        String id = request.getParameter("id");

        Integer count;
        if (request.getParameter("count") != null) {
            count = Integer.parseInt(request.getParameter("count"));
        } else {
            count = 1;
        }

        if (id != null) {

            for(ItemEntity item: items.getItems())
                if (item.getId().toString().equals(id)) {
                    cart.addItem(item, count);
                }
        }
        response.sendRedirect("/cart.jsp");
//        response.sendRedirect(request.getHeader("Referer"));
    }
}
