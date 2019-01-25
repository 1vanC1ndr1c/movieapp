package movieapp.controllers;


import movieapp.repositories.MovieRepository;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/movie")//this one combines with the one below
@Controller
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
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

        model.addAttribute("movie", movieRepository.findById(new Long(id)));

        return "movie/show";
    }



}