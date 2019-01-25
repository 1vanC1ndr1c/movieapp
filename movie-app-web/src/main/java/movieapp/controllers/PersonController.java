package movieapp.controllers;

import movieapp.repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/person")//this one combines with the one below
@Controller
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
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

        model.addAttribute("person", personRepository.findById(new Long(id)));

        return "person/show";
    }


}
