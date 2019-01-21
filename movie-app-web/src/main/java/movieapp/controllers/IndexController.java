package movieapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "", "Index", "Index.html","index","index.html"})
    public String index() {

        return "index";//look for a template called index

    }
}
