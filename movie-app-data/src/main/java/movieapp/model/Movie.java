package movieapp.model;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {
    //TODO private Double averageRating;

    @Column(name = "movieDescription")
    private String movieDescription;

    @Lob
    @Column(name = "movieRuntime")
    private MovieRuntime movieRuntime = new MovieRuntime();

    @Lob
    @Column(name = "releaseDate")
    private CustomDate releaseDate = new CustomDate();

    @Lob
    @Column(name = "category")
    @ElementCollection(targetClass = MovieCategory.class)
    @Enumerated(value = EnumType.STRING)
    private List<MovieCategory> movieCategoryList = new ArrayList<>();

    @Lob
    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection(targetClass = EntityByRoles.class)
    private Set<EntityByRoles> peopleByRolesSet = new LinkedHashSet<>();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (EntityByRoles entityByRoles : peopleByRolesSet) {
            builder.append(entityByRoles.getPersonRole().toString() + ":");
            for (String name : entityByRoles.getNames())
                builder.append(name + " ");
            builder.append(System.getProperty("line.separator"));
        }

        return getName() + '\n' +
                "movieDescription='" + movieDescription + '\n' +
                ", movieRuntime=" + movieRuntime + '\n' +
                ", releaseDate=" + releaseDate + '\n' +
                ", movieCategoryList=" + movieCategoryList + '\n' +
                ", Cast and Crew=" + '\n' + builder.toString();
    }
}
