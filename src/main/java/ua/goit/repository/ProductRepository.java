package ua.goit.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import ua.goit.config.DataBaseManager;
import ua.goit.model.dao.ProductDao;

import java.util.List;
import java.util.Optional;

public class ProductRepository implements Repository<ProductDao> {

    public static final String SELECT_BY_NAME = "FROM ProductDao pd where pd.name=:name";
    public static final String SELECT_ALL = "FROM ProductDao";

    private final DataBaseManager manager;

    public ProductRepository(DataBaseManager manager) {
        this.manager = manager;
    }

    @Override
    public ProductDao findById(Integer id) {
        Transaction transaction = null;
        try (Session session = manager.getSession()) {
            transaction = session.beginTransaction();
            ProductDao productDao = session.get(ProductDao.class, id);
            transaction.commit();
            return productDao;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void save(ProductDao productDao) {
        Transaction transaction = null;
        try (Session session = manager.getSession()) {
            transaction = session.beginTransaction();
            session.merge(productDao);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    private Optional<ProductDao> findByIdOptional(Integer id) {
        Transaction transaction = null;
        try (Session session = manager.getSession()) {
            transaction = session.beginTransaction();
            ProductDao productDao = session.get(ProductDao.class, id);
            transaction.commit();
            return Optional.ofNullable(productDao);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Optional.empty();
    }

    @Override
    public void remove(Integer id) {
        Transaction transaction = null;
        try (Session session = manager.getSession()) {
            transaction = session.beginTransaction();
            findByIdOptional(id).orElseThrow(() -> new IllegalArgumentException(String.format("Product with id %s not found", id)));
            ProductDao productDao = session.get(ProductDao.class, id);
            session.remove(productDao);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public ProductDao update(ProductDao productDao) {
        Transaction transaction = null;
        try (Session session = manager.getSession()) {
            transaction = session.beginTransaction();
            Integer id = productDao.getId();
            findByIdOptional(id).orElseThrow(() -> new IllegalArgumentException(String.format("Promotion with id %s not found", id)));
            ProductDao updatedProductDao = session.merge(productDao);
            transaction.commit();
            return updatedProductDao;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    public List<ProductDao> findByName(String name) {
        try (Session session = manager.getSession()){
            List<ProductDao> productDaos = session.createQuery(SELECT_BY_NAME)
                    .setParameter("name", name)
                    .setResultListTransformer(Transformers.aliasToBean(ProductDao.class))
                    .list();
            return productDaos;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public List<ProductDao> findAll() {
        try (Session session = manager.getSession()){
            List<ProductDao> productDaos = session.createQuery(SELECT_ALL)
                    .setResultListTransformer(Transformers.aliasToBean(ProductDao.class))
                    .list();
            return productDaos;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
