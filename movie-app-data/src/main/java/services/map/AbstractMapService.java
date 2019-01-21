package services.map;

import java.util.*;

public abstract class AbstractMapService <T, ID extends Long> {

    //TODO
    //    Set<T> findAll();
    //
    //    T findById(ID id);
    //
    //    List<String> findByName(String name);
    //
    //    T save(T object);
    //
    //    void delete(T object);
    //
    //    void deleteById(ID id);

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
