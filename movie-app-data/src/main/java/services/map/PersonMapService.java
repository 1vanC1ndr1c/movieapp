package services.map;

import model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import services.PersonService;

import java.util.List;
import java.util.Set;


@Service
@Profile({"default", "map"})
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
