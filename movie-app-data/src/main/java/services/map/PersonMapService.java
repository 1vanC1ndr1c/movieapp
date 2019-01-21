package services.map;

import model.Person;
import services.PersonService;

import java.util.List;
import java.util.Set;

public class PersonMapService  extends AbstractMapService<Person, Long> implements PersonService {

    //TODO EVERYTHING

    @Override
    public Set<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(Long aLong) {
        return null;
    }

    @Override
    public List<String> findByName(String name) {
        return null;
    }

    @Override
    public Person save(Person object) {
        return null;
    }

    @Override
    public void delete(Person object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
