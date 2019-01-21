package services;

import java.util.List;
import java.util.Set;

//interface that mimics spring data repository
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    List<String> findByName(String name);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
