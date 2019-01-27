package movieapp.bootstrap;

import movieapp.model.*;
import movieapp.repositories.MovieRepository;
import movieapp.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
//@Profile("dataloader")
public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    public DataLoader(MovieRepository movieRepository, PersonRepository personRepository) {
        this.movieRepository = movieRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = movieRepository.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        //make some persons
        Person frank = new Person();
        frank.setName("Francis Ford Copolla");
        frank.setBio("Francis Ford Coppola was releaseDate in 1939 in Detroit, Michigan, " +
                " but grew up in a New York suburb in a creative, " +
                " supportive Italian-American family. His father, Carmine Coppola, " +
                " was a composer and musician. His mother, Italia Coppola (née Pennino), " +
                " had been an actress.");
        frank.setBirthPlace(" Detroit, Michigan, USA");
        frank.setBirthDate(new CustomDate(1939, 04, 07));
        List<Role> roles = new ArrayList<>();
        roles.add(Role.DIRECTOR);
        roles.add(Role.PRODUCER);
        roles.add(Role.WRITER);
        frank.setRoles(roles);

        Person puzo = new Person();
        puzo.setName("Mario Puzo");
        puzo.setBio("Mario Puzo was born October 15, 1920, in \"Hell's Kitchen\" on Manhattan's (NY) West Side and, " +
                " following military service in World War II, " +
                " attended New York's New School for Social Research and Columbia University." +
                " His best-known novel, \"The Godfather,\" was preceded by two critically" +
                " acclaimed novels, \"The Dark Arena\" and \"The Fortunate Pilgrim.");
        puzo.setBirthPlace("Manhattan, New York City, New York, USA");
        puzo.setBirthDate(new CustomDate(1920, 10, 15));
        List<Role> roles2 = new ArrayList<>();
        roles2.add(Role.WRITER);
        puzo.setRoles(roles2);

        Person brando = new Person();
        brando.setName("Marlon Brando");
        brando.setBio("Marlon Brando is widely considered the greatest movie actor of all time," +
                " rivaled only by the more theatrically oriented Laurence Olivier in terms of esteem." +
                " Unlike Olivier, who preferred the stage to the screen, Brando concentrated his talents on " +
                " movies after bidding the Broadway stage adieu in 1949," +
                " a decision for which he was severely criticized.");
        brando.setBirthPlace("Omaha, Nebraska, USA");
        brando.setBirthDate(new CustomDate(1947, 04, 03));
        List<Role> roles3 = new ArrayList<>();
        roles3.add(Role.DIRECTOR);
        roles3.add(Role.ACTOR);
        roles3.add(Role.SOUNDTRACK);
        brando.setRoles(roles3);

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
        List<Role> roles4 = new ArrayList<>();
        roles4.add(Role.PRODUCER);
        roles4.add(Role.ACTOR);
        roles4.add(Role.SOUNDTRACK);
        pacino.setRoles(roles4);

        personRepository.save(puzo);
        personRepository.save(frank);
        personRepository.save(brando);
        personRepository.save(pacino);

        //1st movie
        Movie godfather = new Movie();
        godfather.setName("The Godfather");
        godfather.setMovieDescription("The aging patriarch of an organized crime dynasty transfers control " +
                " of his clandestine empire to his reluctant son.");
        godfather.setMovieRuntime(new MovieRuntime(2, 55));
        godfather.setReleaseDate(new CustomDate(1972, 3, 24));
        List<Category> categories = new ArrayList<>();
        categories.add(Category.Crime);
        godfather.setCategoryList(categories);
        Set<EntityByRoles> godfatherCast = new LinkedHashSet<>();
        setPeopleJobs(Role.DIRECTOR, godfatherCast, frank);
        setPeopleJobs(Role.ACTOR, godfatherCast, brando, pacino);
        setPeopleJobs(Role.WRITER, godfatherCast, puzo);
        godfather.setPeopleByRolesSet(godfatherCast);

        //2nd movie
        Movie godfatherII = new Movie();
        godfatherII.setName("The Godfather: Part II");
        godfatherII.setMovieDescription("The early life and career of Vito Corleone in 1920s New York City is portrayed," +
                " while his son, Michael, expands and tightens his grip on the family crime syndicate");
        godfatherII.setMovieRuntime(new MovieRuntime(3, 22));
        godfatherII.setReleaseDate(new CustomDate(1974, 12, 20));
        godfatherII.setCategoryList(categories);
        Set<EntityByRoles> godfatherIICast = new LinkedHashSet<>();
        setPeopleJobs(Role.DIRECTOR, godfatherIICast, frank);
        setPeopleJobs(Role.ACTOR, godfatherIICast, pacino);
        setPeopleJobs(Role.WRITER, godfatherIICast, puzo);
        godfatherII.setPeopleByRolesSet(godfatherIICast);

        movieRepository.save(godfatherII);
        movieRepository.save(godfather);

        Set<EntityByRoles> frankFilmography = new LinkedHashSet<>();
        setPeopleFilmography(Role.DIRECTOR, frankFilmography, godfather, godfatherII);
        setPeopleFilmography(Role.WRITER, frankFilmography, godfather, godfatherII);
        frank.setMoviesByRolesSet(frankFilmography);

        Set<EntityByRoles> puzoFilmography = new LinkedHashSet<>();
        setPeopleFilmography(Role.WRITER, puzoFilmography, godfather, godfatherII);
        puzo.setMoviesByRolesSet(puzoFilmography);

        Set<EntityByRoles> pacinoFilmography = new LinkedHashSet<>();
        setPeopleFilmography(Role.ACTOR, pacinoFilmography, godfather, godfatherII);
        pacino.setMoviesByRolesSet(pacinoFilmography);

        Set<EntityByRoles> brandoFilmography = new LinkedHashSet<>();
        setPeopleFilmography(Role.ACTOR, brandoFilmography, godfather);
        brando.setMoviesByRolesSet(brandoFilmography);


        personRepository.save(frank);
        personRepository.save(puzo);
        personRepository.save(brando);
        personRepository.save(pacino);
/*
        System.out.println(godfather);
        System.out.println(godfatherII);

        System.out.println(frank);
        System.out.println(brando);
        System.out.println(puzo);
        System.out.println(pacino);
*/
    }

    public void setPeopleJobs(Role role, Set<EntityByRoles> cast, Person... people) {
        EntityByRoles movieJob = new EntityByRoles();
        movieJob.setRole(role);

        Set<String> movieJobSet = new LinkedHashSet<>();
        Set<Long> peopleIdList = new LinkedHashSet<>();

        Person person;
        for (int i = 0; i < people.length; i++) {
            person = people[i];
            movieJobSet.add(person.getName());
            peopleIdList.add(person.getId());
        }
        movieJob.setNames(movieJobSet);
        movieJob.setIds(peopleIdList);
        cast.add(movieJob);
    }

    public void setPeopleFilmography(Role role, Set<EntityByRoles> personFilmography, Movie... movies) {
        EntityByRoles personMovieByRole = new EntityByRoles();
        personMovieByRole.setRole(role);

        Set<String> movieList = new LinkedHashSet<>();
        Set<Long> movieIdList = new LinkedHashSet<>();

        Movie movie;
        for (int i = 0; i < movies.length; i++) {
            movie = movies[i];
            movieList.add(movie.getName());
            movieIdList.add(movie.getId());
        }
        personMovieByRole.setNames(movieList);
        personMovieByRole.setIds(movieIdList);
        personFilmography.add(personMovieByRole);
    }
}
