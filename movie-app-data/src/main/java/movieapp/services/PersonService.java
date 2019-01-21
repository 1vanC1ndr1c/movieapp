package movieapp.services;

import movieapp.model.Person;

public interface PersonService extends CrudService<Person, Long> {
    //everything is in the crud interface that is being extended
}
