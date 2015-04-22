package edu.etu.web;

import edu.etu.web.models.HistoryEntity;
import edu.etu.web.models.ItemEntity;
import edu.etu.web.models.ReviewEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
 * Created by korkota on 4/22/15.
 */
@WebServlet(name = "DoReview")
public class DoReview extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);

        String message = request.getParameter("message");

        final Session hSession = HibernateUtil.getSession();

        try {
            Transaction transaction = hSession.beginTransaction();
            ReviewEntity reviewEntity = new ReviewEntity();
            reviewEntity.setUserId(request.getUserPrincipal().getName());
            reviewEntity.setMessage(message);
            reviewEntity.setDate(new Date(System.currentTimeMillis()));
            hSession.save(reviewEntity);
            transaction.commit();
        } finally {
            hSession.close();
        }
    }
}
