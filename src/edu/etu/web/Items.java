package edu.etu.web;

import edu.etu.web.models.HistoryEntity;
import edu.etu.web.models.ItemEntity;
import edu.etu.web.models.MarketEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Алексей on 25.03.2015.
 */
public class Items {
    public List<ItemEntity> getItems() {
        Session session = null;
        Transaction tx = null;
        List<ItemEntity> list = null;

        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list = (List<ItemEntity>) session.createCriteria(ItemEntity.class).list();
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
