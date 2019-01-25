package movieapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder

@Entity
@Table(name = "person")
public class Person extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "bio", length = 20000)
    private String bio;

    @Column(name = "birthPlace")
    private String birthPlace;

    @Column(name = "birthDate", length = 20000)
    private CustomDate birthDate = new CustomDate();

    @Column(name = "roles", length = 20000)
    @ElementCollection(targetClass = Role.class)
    @Enumerated(value = EnumType.STRING)
    private List<Role> roles = new ArrayList<>();

    //  @ElementCollection(targetClass = Movie.class)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "filmography_person", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> filmography = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder movies = new StringBuilder();
        for (int i = 0; i < filmography.size(); i++) {
            if (i == filmography.size() - 1) movies.append(filmography.get(i).getMovieName() + ".");
            else movies.append(filmography.get(i).getMovieName() + ", ");
        }

        return "Person{" +
                "name='" + name + '\'' + "\n" +
                ", roles=" + roles.toString() + "\n" +
                ", bio='" + bio + '\'' + "\n" +
                ", releaseDate=" + birthDate + "\n" +
                ", birthPlace='" + birthPlace + '\'' + "\n" +
                ", filmography='" + movies.toString() + '\'' + "\n" +
                '}';
    }
}
