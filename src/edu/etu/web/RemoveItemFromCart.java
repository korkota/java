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
 * Created by Алексей on 02.04.2015.
 */
@WebServlet(name = "RemoveItemFromCart")
public class RemoveItemFromCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cart cart = (Cart)session.getAttribute("cart");

        ServletContext context = getServletContext();
        Items items = (Items)context.getAttribute("items");

        String id = request.getParameter("id");


        if (id != null) {
            for(ItemEntity item: items.getItems())
                if (item.getId().toString().equals(id)) cart.getCart().remove(item);
        }
        response.sendRedirect("/cart.jsp");
//        response.sendRedirect(request.getHeader("Referer"));
    }
}
