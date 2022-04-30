package ua.goit.repository;

import ua.goit.model.dao.ProductDao;

import java.util.Optional;

public class ProductRepository implements Repository<ProductDao> {
    @Override
    public void save(ProductDao productDao) {

    }

    @Override
    public Optional<ProductDao> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public int update(Integer id, ProductDao productDao) {
        return 0;
    }
}
