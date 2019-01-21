package services.map;

import model.Movie;
import services.MovieService;

import java.util.List;
import java.util.Set;

public class MovieMapService extends AbstractMapService<Movie, Long> implements MovieService {

    //TODO EVERYTHING

    @Override
    public Set<Movie> findAll() {
        return null;
    }

    @Override
    public Movie findById(Long aLong) {
        return null;
    }

    @Override
    public List<String> findByName(String name) {
        return null;
    }

    @Override
    public Movie save(Movie object) {
        return null;
    }

    @Override
    public void delete(Movie object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
