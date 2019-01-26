package movieapp.controllers;


import movieapp.model.*;
import movieapp.repositories.MovieRepository;
import movieapp.repositories.PersonRepository;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/movie")//this one combines with the one below
@Controller
public class MovieController {

    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    public MovieController(MovieRepository movieRepository, PersonRepository personRepository, PersonRepository personRepository1) {
        this.movieRepository = movieRepository;
        this.personRepository = personRepository1;
    }

    @RequestMapping({"/", "", "Index", "Index.html", "index", "index.html"})
    public String listMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());

        return "movie/index";

    }

    @GetMapping("/{id}/show")
    //good habit to do, only expecting get methods
    //get mapping ~ request mapping
    public String showById(@PathVariable String id, Model model) {
        Movie movie = (Movie) movieRepository.findById(Long.valueOf(id)).orElse(null);
        List<Person> directors = getPeopleByRoles(movie, Role.DIRECTOR);
        List<Person> writers = getPeopleByRoles(movie, Role.WRITER);
        List<Person> actors = getPeopleByRoles(movie, Role.ACTOR);

        model.addAttribute("movie",movieRepository.findById(new Long(id)));
        model.addAttribute("directors", directors);
        model.addAttribute("writers", writers);
        model.addAttribute("actors", actors);

        return "movie/show";
    }

    private List<Person> getPeopleByRoles(Movie movie, Role role) {
        List<Person> people = new ArrayList<>();

        for (EntityByRoles entityByRoles : movie.getPeopleByRolesList()) {
            if (entityByRoles.getRole().equals(role))
                for (Object o : entityByRoles.getList()) {
                    if (o instanceof BaseEntity) people.add((Person) o);
                    else throw new IllegalArgumentException("Not good");
                }
        }
        return people;
    }


}