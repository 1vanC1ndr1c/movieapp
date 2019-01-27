package movieapp.controllers;

import movieapp.model.*;
import movieapp.repositories.MovieRepository;
import movieapp.repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@RequestMapping("/person")//this one combines with the one below
@Controller
public class PersonController {

    private final PersonRepository personRepository;
    private final MovieRepository movieRepository;

    public PersonController(PersonRepository personRepository, MovieRepository movieRepository) {
        this.personRepository = personRepository;
        this.movieRepository = movieRepository;
    }

    @RequestMapping({"/", "", "Index", "Index.html", "index", "index.html"})
    public String listPersons(Model model) {
        model.addAttribute("persons", personRepository.findAll());

        return "person/index";
    }

    @GetMapping("/{id}/show")
    //good habit to do, only expecting get methods
    //get mapping ~ request mapping
    public String showById(@PathVariable String id, Model model) {
        Person person = personRepository.findById(Long.valueOf(id)).orElse(null);
        Set<Movie> filmography = getMoviesByIds(getMovieIds(person));

        model.addAttribute("person", personRepository.findById(new Long(id)));
        model.addAttribute("filmography", filmography);

        return "person/show";
    }

    private Set<Long> getMovieIds(Person person) {
        Set<Long> movieIds = new LinkedHashSet<>();
        for (EntityByRoles entityByRoles : person.getMoviesByRolesSet())
           movieIds.addAll(entityByRoles.getIds());
        return movieIds;
    }

    private Set<Movie> getMoviesByIds(Set<Long> movieIds) {
        Set<Movie> movies = new LinkedHashSet<>();
        Movie movie;
        for (Long id : movieIds) {
            movie = movieRepository.findById(id).orElse(null);
            movies.add(movie);
        }
        return movies;
    }
}
