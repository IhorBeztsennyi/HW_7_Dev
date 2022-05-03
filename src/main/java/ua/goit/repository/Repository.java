package ua.goit.repository;

public interface Repository<T> {

    void save(T t);

    T findById(Integer id);

    void remove(Integer id);

    T update(T t);
}
