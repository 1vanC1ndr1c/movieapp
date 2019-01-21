package movieapp.bootstrap;

import model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader  implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception{

        loadData();

    }

    private void loadData(){

        Movie godfather = new Movie();
        godfather.setName("Godfather");
        godfather.setMovieRuntime(new MovieRuntime(2, 55));
        godfather.setReleaseDate(new MovieReleaseDate(1972, "March", 24));

        //make some persons
        Person frank = new Person();
        frank.setName("Francis Ford Copolla");

        Person brando= new Person();
        brando.setName("Marlon Brando");

        Person puzo = new Person();
        puzo.setName("Mario Puzo");

        List<Person> director = new ArrayList<>();
        director.add(frank);
        godfather.setDirectors(director);

        List<Person> writer = new ArrayList<>();
        writer.add(puzo);
        godfather.setWriters(writer);

        List<Person> actor = new ArrayList<>();
        actor.add(brando);
        godfather.setStars(actor);

        godfather.setId(2l);

        List<Category> categories = new ArrayList<>();
        categories.add(Category.Crime);
        godfather.setCategoryList(categories);

        System.out.println(godfather);
    }
}
