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
//    private Item[] items = {
//            new Item("1", "Экран для проектора", 500.0,
//                    "<b>Тип конструкции:</b> Экран с электроприводом <br/>" +
//                    "<b>Полотно</b>: Матовое<br/>" +
//                    "<b>Формат</b>: 16:10<br/>",
//                    "<b>Тип конструкции:</b> Экран с электроприводом <br/>" +
//                    "<b>Полотно</b>: Матовое<br/>" +
//                    "<b>Формат</b>: 16:10<br/>" +
//                    "<b>Диагональ, см:</b> 144<br/>" +
//                    "<b>Размер экрана, см:</b> 320х204 <br/>" +
//                    "<b>Поддержка 3D:</b> нет<br/>"),
//            new Item("2", "Проектор Epson EMP-X3", 1000.0,
//                    "<b>Разрешение:</b> 800x600 <br/>" +
//                    "<b>Яркость:</b> 2800 Ansi lm <br/>" +
//                    "<b>Контрастность:</b> 13000:1 <br/>",
//                    "<b>Разрешение:</b> 800x600 <br/>" +
//                    "<b>Яркость:</b> 2800 Ansi lm <br/>" +
//                    "<b>Контрастность:</b> 13000:1 <br/>" +
//                    "<b>Тип подсветки:</b> Ламповая <br/>" +
//                    "<b>Лампа:</b> OSRAM <br/>"),
//            new Item("3", "Проектор BenQ MS504", 1100.0,
//                    "<b>Разрешение:</b> 800x600 <br/>" +
//                    "<b>Яркость:</b> 3000 Ansi lm <br/>" +
//                    "<b>Контрастность:</b> 14000:1 <br/>",
//                    "<b>Разрешение:</b> 800x600 <br/>" +
//                    "<b>Яркость:</b> 3000 Ansi lm <br/>" +
//                    "<b>Контрастность:</b> 14000:1 <br/>" +
//                    "<b>Тип подсветки:</b> Ламповая <br/>" +
//                    "<b>Лампа:</b> 190 Вт <br/>"),
//            new Item("4", "Cетевой фильтр SVEN Optima", 100.0,
//                    "<b>Цвет:</b> Черный <br/>" +
//                    "<b>Количество розеток :</b> 5 <br/>" +
//                    "<b>Длина кабеля, м:</b> 1.8 <br/>",
//                    "<b>Цвет:</b> Черный <br/>" +
//                    "<b>Количество розеток :</b> 5 <br/>" +
//                    "<b>Длина кабеля, м:</b> 1.8 <br/>" +
//                    "<b>Максимальный ток нагрузки, A:</b> 10 <br/>")
//    };

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
