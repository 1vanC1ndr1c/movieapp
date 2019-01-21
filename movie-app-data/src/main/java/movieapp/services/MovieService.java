package movieapp.services;

import movieapp.model.Movie;

public interface MovieService extends CrudService<Movie, Long> {
    //everything is in the crud interface that is being extended
}
