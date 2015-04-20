package edu.etu.web;

import edu.etu.web.models.HistoryEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by korkota on 4/20/15.
 */
public class History {
    public List getHistory() {
        Session session = null;
        Transaction tx = null;
        List list = null;

        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list =  session.createCriteria(HistoryEntity.class)
                    .createAlias("market_id", "market")
                    .list();
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
