package movieapp.model;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {
    //TODO private Double averageRating;

    @Column(name = "movieDescription")
    private String movieDescription;

    @Column(name = "movieRuntime", length = 20000)
    private MovieRuntime movieRuntime = new MovieRuntime();

    @Column(name = "releaseDate", length = 2046)
    private CustomDate releaseDate = new CustomDate();

    @Column(name = "category", length = 20000)
    @ElementCollection(targetClass = Category.class)
    @Enumerated(value = EnumType.STRING)
    private List<Category> categoryList = new ArrayList<>();

    @Column(name = "peopleByRolesList", length = 20000)
    @ElementCollection(targetClass = EntityByRoles.class)
    private List<EntityByRoles> peopleByRolesList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (EntityByRoles entityByRoles : peopleByRolesList) {
            builder.append(entityByRoles.getRole().toString() + ":");
            for (Object o : entityByRoles.getList()) {
                if (o instanceof BaseEntity) builder.append(((BaseEntity) o).getName().toString() + " ");
                else throw new IllegalArgumentException("Not good");
            }
            builder.append(System.getProperty("line.separator"));
        }
        return getName() + '\n' +
                "movieDescription='" + movieDescription + '\n' +
                ", movieRuntime=" + movieRuntime + '\n' +
                ", releaseDate=" + releaseDate + '\n' +
                ", categoryList=" + categoryList + '\n' +
                ", Cast and Crew=" + '\n' + builder.toString();
    }
}
