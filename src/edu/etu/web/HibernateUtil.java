package edu.etu.web;

import edu.etu.web.models.HistoryEntity;
import edu.etu.web.models.MarketEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by korkota on 4/20/15.
 */
public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
////        try {
////            System.out.println("querying all the managed entities...");
////            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
////            for (Object key : metadataMap.keySet()) {
////                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
////                final String entityName = classMetadata.getEntityName();
////                final Query query = session.createQuery("from " + entityName);
////                System.out.println("executing: " + query.getQueryString());
////                for (Object o : query.list()) {
////                    System.out.println("  " + o);
////                }
////            }
////
////            Transaction transaction = session.beginTransaction();
////            HistoryEntity historyEntity = new HistoryEntity();
////            historyEntity.setDate(new Date(System.currentTimeMillis()));
////            historyEntity.setDeliveryAddress("sfdsfsasafd");
////            historyEntity.setUserId("test");
////            session.save(historyEntity);
////            transaction.commit();
////
////        } finally {
////            session.close();
////        }
//
//        try {
//            Transaction transaction = session.beginTransaction();
//            MarketEntity marketEntity = new MarketEntity();
//            marketEntity.setName("Юлмарт");
//            marketEntity.setAddress("ул. Торжковская, дом 15");
//            session.save(marketEntity);
//            transaction.commit();
//        } finally {
//            session.close();
//        }


        Session session = null;
        Transaction tx = null;
        StringBuilder sb = new StringBuilder();

        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            List list = session.createCriteria(HistoryEntity.class).list();
            sb.append("Всего куплено товаров: ").append(list.size()).append("<br><br>");

            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                HistoryEntity cur = (HistoryEntity) iterator.next();
                sb.append(cur.getClass().toString());
                sb.append("<b>Название товара: </b>").append(cur.getItemId());
                sb.append("<b>Магазин: </b>").append(cur.getMarketId());
                sb.append("<br>");
            }
            System.out.print(sb.toString());
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
