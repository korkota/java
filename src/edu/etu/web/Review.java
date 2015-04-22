package edu.etu.web;

import edu.etu.web.models.ReviewEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by korkota on 4/22/15.
 */
public class Review {
    public List<ReviewEntity> getReviews() {
        Session session = null;
        Transaction tx = null;
        List<ReviewEntity> list = null;

        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list = (List<ReviewEntity>) session.createCriteria(ReviewEntity.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }
}
