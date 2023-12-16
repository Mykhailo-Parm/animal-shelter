package ua.nure.animalsheltersystem.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(Long id) throws SQLException;
    List<T> getAll() throws SQLException;
    int save(T t) throws SQLException;
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(Long id) throws SQLException;
}
