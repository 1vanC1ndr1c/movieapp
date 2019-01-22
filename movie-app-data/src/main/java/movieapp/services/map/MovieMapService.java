package movieapp.services.map;


import movieapp.model.Movie;
import movieapp.services.PersonService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import movieapp.services.MovieService;

import java.util.Set;

@Service
@Primary
public class MovieMapService extends AbstractMapService<Movie, Long> implements MovieService {

    private final PersonService personService;

    public MovieMapService(PersonService personService) {
        this.personService = personService;
    }


    @Override
    public Set<Movie> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Movie object) {
        super.delete(object);
    }

    @Override
    public Movie save(Movie object) {
        return super.save(object);
    }

    @Override
    public Movie findById(Long id) {
        return super.findById(id);
    }

}
