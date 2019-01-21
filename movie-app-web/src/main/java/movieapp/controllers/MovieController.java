package movieapp.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import movieapp.services.MovieService;


@RequestMapping("/movie")//this one combines with the one below
@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping({"/", "", "Index", "Index.html", "index", "index.html"})
    public String listMovies(Model model) {

        model.addAttribute("movies", movieService.findAll());

        return "movie/index";

    }


}