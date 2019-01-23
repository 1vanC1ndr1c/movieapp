package movieapp.bootstrap;

import movieapp.model.*;
import movieapp.services.MovieService;
import movieapp.services.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {


    private final MovieService movieService;
    private final PersonService personService;

    public DataLoader(MovieService movieService, PersonService personService) {
        this.movieService = movieService;
        this.personService = personService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = movieService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        //make some persons
        Person frank = new Person();
        frank.setName("Francis Ford Copolla");
        frank.setBio("Francis Ford Coppola was birthDate in 1939 in Detroit, Michigan, " +
                " but grew up in a New York suburb in a creative, " +
                " supportive Italian-American family. His father, Carmine Coppola, " +
                " was a composer and musician. His mother, Italia Coppola (née Pennino), " +
                " had been an actress.");
        frank.setBirthPlace(" Detroit, Michigan, USA");
        frank.setBirthDate(new CustomDate(1939, "April", 7));
        frank.setFilmography("Apocalypse Now, Godfather, Dracula");
        frank.setRoles(new String[]{"Producer", "Director", "Writer"});

        Person brando = new Person();
        brando.setName("Marlon Brando");
        brando.setBio("Marlon Brando is widely considered the greatest movie actor of all time," +
                " rivaled only by the more theatrically oriented Laurence Olivier in terms of esteem." +
                " Unlike Olivier, who preferred the stage to the screen, Brando concentrated his talents on " +
                " movies after bidding the Broadway stage adieu in 1949," +
                " a decision for which he was severely criticized.");
        brando.setBirthPlace("Omaha, Nebraska, USA");
        brando.setBirthDate(new CustomDate(1947, 4, 3));
        brando.setRoles(new String[]{"Actor", "Director", "Soundtrack"});
        brando.setFilmography("Apocalypse Now, Godfather, On the WaterFront");

        Person puzo = new Person();
        puzo.setName("Mario Puzo");
        puzo.setBio("Mario Puzo was born October 15, 1920, in \"Hell's Kitchen\" on Manhattan's (NY) West Side and, " +
                " following military service in World War II, " +
                " attended New York's New School for Social Research and Columbia University." +
                " His best-known novel, \"The Godfather,\" was preceded by two critically" +
                " acclaimed novels, \"The Dark Arena\" and \"The Fortunate Pilgrim.");
        puzo.setBirthPlace("Manhattan, New York City, New York, USA");
        puzo.setBirthDate(new CustomDate(1920, "October", 15));
        puzo.setRoles(new String[]{"Writer"});
        puzo.setFilmography("Godfather, Godfather Part II, Godfather Part III");

        Person pacino = new Person();
        pacino.setName("Al Pacino");
        pacino.setBio("One of the greatest actors in all of film history," +
                " Al Pacino established himself during one of cinema's most vibrant decades," +
                " the 1970s, and has become an enduring and iconic figure in the world of" +
                " American movies." +
                " Alfredo James Pacino was born on April 25, 1940 in Manhattan, " +
                " New York City, to an Italian-American family.");
        pacino.setBirthPlace("Manhattan, New York City, New York, USA");
        pacino.setBirthDate(new CustomDate(1940, 4, 25));
        pacino.setRoles(new String[]{"Actor", "Producer", "Soundtrack"});
        pacino.setFilmography("Godfather, Godfather Part II, Godfather Part III");


        personService.save(frank);
        personService.save(brando);
        personService.save(puzo);
        personService.save(pacino);
        System.out.println(frank);
        System.out.println(brando);
        System.out.println(puzo);
        System.out.println(pacino);

        //1st movie
        Movie godfather = new Movie();
        godfather.setName("Godfather");
        godfather.setDescription("The aging patriarch of an organized crime dynasty transfers control " +
                " of his clandestine empire to his reluctant son.");
        godfather.setMovieRuntime(new MovieRuntime(2, 55));
        godfather.setReleaseDate(new CustomDate(1972, "March", 24));
        List<Person> director = new ArrayList<>();
        director.add(frank);
        godfather.setDirectors(director);
        List<Person> writer = new ArrayList<>();
        writer.add(puzo);
        godfather.setWriters(writer);
        List<Person> actor = new ArrayList<>();
        actor.add(brando);
        godfather.setStars(actor);
        List<Category> categories = new ArrayList<>();
        categories.add(Category.Crime);
        godfather.setCategoryList(categories);
        movieService.save(godfather);
        System.out.println(godfather);


        //2nd movie
        Movie godfatherII = new Movie();
        godfatherII.setName("GodfatherII");
        godfatherII.setDescription("The early life and career of Vito Corleone in 1920s New York City is portrayed," +
                " while his son, Michael, expands and tightens his grip on the family crime syndicate");
        godfatherII.setMovieRuntime(new MovieRuntime(3, 22));
        godfatherII.setReleaseDate(new CustomDate(1974, "December", 20));
        List<Person> directorII = new ArrayList<>();
        directorII.add(frank);
        godfatherII.setDirectors(director);
        List<Person> writerII = new ArrayList<>();
        writerII.add(puzo);
        godfatherII.setWriters(writer);
        List<Person> actorII = new ArrayList<>();
        actorII.add(brando);
        actorII.add(pacino);
        godfatherII.setStars(actorII);
        List<Category> categoriesII = new ArrayList<>();
        categoriesII.add(Category.Crime);
        godfatherII.setCategoryList(categories);
        movieService.save(godfatherII);
        System.out.println(godfatherII);

    }
}
