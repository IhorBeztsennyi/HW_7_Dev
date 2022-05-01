package ua.goit;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.config.DataBaseManager;
import ua.goit.config.HibernateProvider;
import ua.goit.model.Store;
import ua.goit.model.dao.ProductDao;
import ua.goit.model.dao.PromotionDao;
import ua.goit.repository.ProductRepository;
import ua.goit.repository.PromotionRepository;

import java.util.List;

public class App {
    public static void main(String[] args) {
        DataBaseManager manager = new HibernateProvider();
        HibernateProvider.init();
        ProductRepository productRepository = new ProductRepository(manager);
        PromotionRepository promotionRepository = new PromotionRepository(manager);


//        PromotionDao promotionDao = new PromotionDao();
//        promotionDao.setAmount(5);
//        promotionDao.setPrice(6.5);
//        PromotionDao promotionDao1 = promotionRepository.findById(1);
//        ProductDao productDao = new ProductDao();
//        productDao.setName("H");
//        productDao.setPrice(1.77);
//        productDao.setPromotionDao(promotionRepository.findById(2));
//        List<ProductDao> foundProducts = productRepository.findByName("A");
//        ProductDao fondPr = foundProducts.get(0);
//
//        System.out.println(foundProducts);
//        System.out.println(fondPr);
        Store store = new Store(productRepository);
        String productSet = "ABCDABA";
        System.out.println(store.getFinalPrice(productSet));



//        productRepository.save(productDao);
//        promotionRepository.remove(5);
//        session.persist(productDao);




    }
}
