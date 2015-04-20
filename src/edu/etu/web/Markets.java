package edu.etu.web;

import edu.etu.web.models.HistoryEntity;
import edu.etu.web.models.MarketEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by korkota on 4/20/15.
 */
public class Markets {

    public List getMarkets() {
        Session session = null;
        Transaction tx = null;
        List<MarketEntity> list = null;

        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list = session.createCriteria(MarketEntity.class).list();
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
