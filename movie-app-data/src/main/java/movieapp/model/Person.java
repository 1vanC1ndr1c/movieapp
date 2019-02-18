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

    @Lob
    @Column(name = "bio")
    private String bio;

    @Column(name = "birthPlace")
    private String birthPlace;

    @Lob
    @Column(name = "birthDate")
    private CustomDate birthDate = new CustomDate();

    @Lob
    @Column(name = "personRoles")
    @ElementCollection(targetClass = PersonRole.class)
    @Enumerated(value = EnumType.STRING)
    private List<PersonRole> personRoles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
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
                ", personRoles=" + personRoles.toString() + '\n' +
                ", filmography=" + filmography.toString();
    }
}
