package movieapp.controllers;


import movieapp.model.*;
import movieapp.repositories.MovieRepository;
import movieapp.repositories.PersonRepository;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@RequestMapping("/movie")//this one combines with the one below
@Controller
public class MovieController {

    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    public MovieController(MovieRepository movieRepository, PersonRepository personRepository1) {
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
        Movie movie = movieRepository.findById(Long.valueOf(id)).orElse(null);

        List<Person> directors = getPeopleByIds(getPeopleIds(movie, PersonRole.DIRECTOR));
        List<Person> writers = getPeopleByIds(getPeopleIds(movie, PersonRole.WRITER));
        List<Person> actors = getPeopleByIds(getPeopleIds(movie, PersonRole.ACTOR));

        model.addAttribute("movie", movieRepository.findById(new Long(id)));
        model.addAttribute("directors", directors);
        model.addAttribute("writers", writers);
        model.addAttribute("actors", actors);

        return "movie/show";
    }

    private Set<Long> getPeopleIds(Movie movie, PersonRole personRole) {
        Set<Long> peopleId = new LinkedHashSet<>();
        for (EntityByRoles entityByRoles : movie.getPeopleByRolesSet())
            if (entityByRoles.getPersonRole().equals(personRole))
                peopleId.addAll(entityByRoles.getIds());
        return peopleId;
    }

    private List<Person> getPeopleByIds(Set<Long> peopleIds) {
        List<Person> people = new ArrayList<>();
        Person person;
        for (Long id : peopleIds) {
            person = personRepository.findById(id).orElse(null);
            people.add(person);
        }
        return people;
    }


}