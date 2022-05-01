package ua.goit.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.config.DataBaseManager;
import ua.goit.model.dao.PromotionDao;

import java.util.Optional;

public class PromotionRepository implements Repository<PromotionDao> {

    private final DataBaseManager manager;

    public PromotionRepository(DataBaseManager manager) {
        this.manager = manager;
    }

    @Override
    public void save(PromotionDao promotionDao) {
        Transaction transaction = null;
        try (Session session = manager.getSession()) {
            transaction = session.beginTransaction();
            session.merge(promotionDao);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public PromotionDao findById(Integer id) {
        Transaction transaction = null;
        try (Session session = manager.getSession()) {
            transaction = session.beginTransaction();
            PromotionDao promotionDao = session.get(PromotionDao.class, id);
            transaction.commit();
            return promotionDao;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    private Optional<PromotionDao> findByIdOptional(Integer id) {
        Transaction transaction = null;
        try (Session session = manager.getSession()) {
            transaction = session.beginTransaction();
            PromotionDao promotionDao = session.get(PromotionDao.class, id);
            transaction.commit();
            return Optional.ofNullable(promotionDao);
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
        try (Session session = manager.getSession()){
            transaction = session.beginTransaction();
            findByIdOptional(id).orElseThrow(() -> new IllegalArgumentException(String.format("Promotion with id %s not found", id)));
            PromotionDao promotionDao = session.get(PromotionDao.class, id);
            session.remove(promotionDao);
            transaction.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public PromotionDao update(PromotionDao promotionDao) {
        Transaction transaction = null;
        try (Session session = manager.getSession()){
            transaction = session.beginTransaction();
            Integer id = promotionDao.getId();
            findByIdOptional(id).orElseThrow(() -> new IllegalArgumentException(String.format("Promotion with id %s not found", id)));
            PromotionDao updatedPromotionDao = session.merge(promotionDao);
            transaction.commit();
            return updatedPromotionDao;
        }catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
}
