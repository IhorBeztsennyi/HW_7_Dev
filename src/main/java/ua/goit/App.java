package ua.goit;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.model.dao.ProductDao;
import ua.goit.model.dao.PromotionDao;

public class App {
    public static void main(String[] args) {
        DataBaseManager manager = new HibernateProvider();
        HibernateProvider.init();

        Session session = manager.getSession();
        Transaction transaction = session.beginTransaction();
        PromotionDao promotionDao = new PromotionDao();
        promotionDao.setAmount(5);
        promotionDao.setPrice(6.5);
        ProductDao productDao = new ProductDao();
        productDao.setName("E");
        productDao.setPrice(1.32);
        productDao.setPromotionDao(promotionDao);
//        session.persist(productDao);
        session.getTransaction().commit();



    }
}
