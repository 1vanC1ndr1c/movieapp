package movieapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter

@Table(name = "movies")
public class Movie extends BaseEntity {
    //TODO private Double averageRating;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "runtime")
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Movie.class)
    @ElementCollection(targetClass = MovieRuntime.class)
    private MovieRuntime movieRuntime;

    @Column(name = "category")
    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "movie_category")
    private List<Category> categoryList = new ArrayList<>();

    @JoinColumn(name = "release_date")
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Movie.class)
    @ElementCollection(targetClass = MovieReleaseDate.class)
    private MovieReleaseDate releaseDate;

    @Column(name = "Directors")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> directors = new ArrayList<>();

    @Column(name = "Writers")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> writers = new ArrayList<>();

    @Column(name = "Stars")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> stars = new ArrayList<>();


    public Movie(Long id, String name, MovieRuntime movieRuntime, List<Category> categoryList, MovieReleaseDate releaseDate, List<Person> directors, List<Person> writers, List<Person> stars) {
        super(id);
        this.name = name;
        this.movieRuntime = movieRuntime;
        this.categoryList = categoryList;
        this.releaseDate = releaseDate;
        this.directors = directors;
        this.writers = writers;
        this.stars = stars;
    }

    @Override
    public String toString() {

        StringBuilder directorNames = new StringBuilder();
        for (Person director : directors) {
            directorNames.append(director.getName()).append("  ");
        }
        StringBuilder writerNames = new StringBuilder();
        for (Person writer : writers) {
            writerNames.append(writer.getName()).append("  ");
        }
        StringBuilder starsNames = new StringBuilder();
        for (Person star : stars) {
            starsNames.append(star.getName()).append("  ");
        }

        return "Movie{" + "\n" +
                "id=" + super.getId() + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", movieRuntime=" + movieRuntime + "\n" +
                ", categoryList=" + categoryList + "\n" +
                ", releaseDate=" + releaseDate + "\n" +
                ", directors=" + directorNames + "\n" +
                ", writers=" + writerNames + "\n" +
                ", stars=" + starsNames + "\n" +
                '}';
    }
}
