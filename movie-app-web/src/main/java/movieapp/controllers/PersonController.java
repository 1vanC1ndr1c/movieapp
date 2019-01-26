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
import java.util.List;


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

        List<Movie> filmography = getFilmography(person);

        model.addAttribute("person", personRepository.findById(new Long(id)));
        model.addAttribute("filmography", filmography);

        return "person/show";
    }

    private List<Movie> getFilmography(Person person) {
        List<Movie> filmography = new ArrayList<>();

        for (EntityByRoles entityByRoles : person.getMoviesByRolesList()) {
            for (Object o : entityByRoles.getList()) {
                if (o instanceof Movie) {
                    Movie oMovie = (Movie) o;
                    boolean contains = false;
                    for (Movie movie : filmography) {
                        if (movie.getName().equals(oMovie.getName()))
                             if(movie.getReleaseDate().toString()
                                .equals(oMovie.getReleaseDate().toString())){
                                 contains = true;
                                 break;
                             }
                    }
                    if(contains == false)filmography.add((Movie) o);
                } else throw new IllegalArgumentException("Not good");
            }
        }
        return filmography;
    }


}
