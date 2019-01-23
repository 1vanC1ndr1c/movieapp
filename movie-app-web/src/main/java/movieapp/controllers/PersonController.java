package movieapp.controllers;

import movieapp.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/person")//this one combines with the one below
@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping({"/", "", "Index", "Index.html", "index", "index.html"})
    public String listPersons(Model model) {

        model.addAttribute("persons", personService.findAll());

        return "person/index";
    }

    @GetMapping("/{id}/show")
    //good habit to do, only expecting get methods
    //get mapping ~ request mapping
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("person", personService.findById(new Long(id)));

        return "person/show";
    }


}
