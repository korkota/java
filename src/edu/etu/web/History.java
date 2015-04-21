package edu.etu.web;

import edu.etu.web.models.HistoryEntity;
import org.hibernate.Criteria;
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
            list =  session.createSQLQuery("select item.title as item_title, item_count, delivery_address, market.address as market_address, date from history left join item on history.item_id = item.id left join market on history.market_id = market.id").setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
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
