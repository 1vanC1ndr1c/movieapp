package movieapp.model;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {
    //TODO private Double averageRating;

    @Column(name = "movieName")
    private String movieName;

    @Column(name = "movieDescription")
    private String movieDescription;

    @Column(name = "movieRuntime")
    private MovieRuntime movieRuntime = new MovieRuntime();

    @Column(name = "releaseDate", length = 2046)
    private CustomDate releaseDate = new CustomDate();

    //@ElementCollection(targetClass = Person.class)
    @ManyToMany(mappedBy = "filmography")
    private List<Person> directors = new ArrayList<>();

    @ManyToMany(mappedBy = "filmography")
    private List<Person> writers = new ArrayList<>();

    @ManyToMany(mappedBy = "filmography")
    private List<Person> stars = new ArrayList<>();

    @Column(name = "category", length = 20000)
    @ElementCollection(targetClass = Category.class)
    @Enumerated(value = EnumType.STRING)
    private List<Category> categoryList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder directorNames = new StringBuilder();
        if (directors.size() > 1) directorNames.append("Directors: ");
        else directorNames.append("Director:");
        for (int i = 0; i < directors.size(); i++) {
            if (i == directors.size() - 1) directorNames.append(directors.get(i).getName() + ".");
            else directorNames.append(directors.get(i).getName() + ", ");
        }
        StringBuilder writerNames = new StringBuilder();
        if (writers.size() > 1) writerNames.append("Writers: ");
        else directorNames.append("Writer:");
        for (int i = 0; i < writers.size(); i++) {
            if (i == writers.size() - 1) writerNames.append(writers.get(i).getName() + ".");
            else writerNames.append(writers.get(i).getName() + ", ");
        }
        StringBuilder starNames = new StringBuilder();
        if (stars.size() > 1) starNames.append("Stars: ");
        else starNames.append("Star:");
        for (int i = 0; i < stars.size(); i++) {
            if (i == stars.size() - 1) starNames.append(stars.get(i).getName() + ".");
            else starNames.append(stars.get(i).getName() + ", ");
        }
        return "Movie{" + "\n" +
                "id=" + getId() + "\n" +
                ", name='" + movieName + '\'' + "\n" +
                ", description='" + movieDescription + '\'' + "\n" +
                ", movieRuntime=" + movieRuntime.toString() + "\n" +
                ", categoryList=" + categoryList.toString() + "\n" +
                ", releaseDate=" + releaseDate.toString() + "\n" +
                directorNames.toString() + "\n" +
                writerNames.toString() + "\n" +
                starNames.toString() + "\n";
    }


}
