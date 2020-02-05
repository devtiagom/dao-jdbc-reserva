package dao;

import java.util.List;

public interface DAO<T> {

    public void save(T domain);
    public T saveAndCheck(T domain);

    public void update(T domain);
    public T updateAndCheck(T domain);

    public void delete(T domain);

    public T findById(Long domainId);

    public List<T> findAll();
}
