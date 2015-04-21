package edu.etu.web;

import edu.etu.web.models.HistoryEntity;
import edu.etu.web.models.ItemEntity;
import edu.etu.web.models.MarketEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

/**
 * Created by korkota on 4/20/15.
 */
@WebServlet(name = "DoOrder")
public class DoOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        Cart cart = (Cart)session.getAttribute("cart");

        String address = request.getParameter("address");

        Integer marketId = null;
        if (request.getParameter("marketId") != null) {
            marketId = Integer.parseInt(request.getParameter("marketId"));
        }

        for (Map.Entry<ItemEntity, Integer> item: cart.getCart().entrySet()) {
            final Session hSession = HibernateUtil.getSession();

            try {
                Transaction transaction = hSession.beginTransaction();
                HistoryEntity historyEntity = new HistoryEntity();
                historyEntity.setMarketId(marketId);
                historyEntity.setUserId(request.getUserPrincipal().getName());
                historyEntity.setDate(new Date(System.currentTimeMillis()));
                historyEntity.setItemCount(item.getValue());
                historyEntity.setItemId(item.getKey().getId());
                historyEntity.setDeliveryAddress(address);
                hSession.save(historyEntity);
                transaction.commit();
                cart.reset();
            } finally {
                hSession.close();
            }
        }

        response.sendRedirect("/history.jsp");
    }
}
