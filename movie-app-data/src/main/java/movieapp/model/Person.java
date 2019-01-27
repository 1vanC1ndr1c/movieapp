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

    @Column(name = "moviesByRolesSet", length = 20000)
    @ElementCollection(targetClass = EntityByRoles.class)
    private Set<EntityByRoles> moviesByRolesSet = new LinkedHashSet<>();

    @Override
    public String toString() {
        List<String> filmography = new ArrayList<>();

        for (EntityByRoles entityByRoles : moviesByRolesSet)
            for (String name : entityByRoles.getNames())
                if (!filmography.contains(name)) filmography.add(name);

        return getName() + '\n' +
                "bio='" + bio + '\n' +
                ", birthPlace='" + birthPlace + '\n' +
                ", birthDate=" + birthDate.toString() + '\n' +
                ", roles=" + roles.toString() + '\n' +
                ", filmography=" + filmography.toString();
    }
}
