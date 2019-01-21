package movieapp.services.map;

import movieapp.model.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import movieapp.services.PersonService;

import java.util.Set;


@Service
@Primary
public class PersonMapService extends AbstractMapService<Person, Long> implements PersonService {
    
    @Override
    public Set<Person> findAll() {
        return super.findAll();
    }

    @Override
    public Person findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Person save(Person object) {
        return super.save(object);
    }

    @Override
    public void delete(Person object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
