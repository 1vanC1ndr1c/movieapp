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

    @Column(name = "moviesByRolesList", length = 2000000)
    @ElementCollection(targetClass = EntityByRoles.class)
    private List<EntityByRoles> moviesByRolesList = new ArrayList<>();

    @Override
    public String toString() {
        List<String> filmography = new ArrayList<>();

        for (EntityByRoles entityByRoles : moviesByRolesList) {
            for (Object o : entityByRoles.getList()) {
                if (o instanceof BaseEntity) {
                    if (!filmography.contains(((BaseEntity) o).getName())) filmography.add(((BaseEntity) o).getName());
                } else {
                    throw new IllegalArgumentException("Not good");
                }
            }
        }
        return getName() + '\n' +
                "bio='" + bio + '\n' +
                ", birthPlace='" + birthPlace + '\n' +
                ", birthDate=" + birthDate.toString() + '\n' +
                ", roles=" + roles.toString() + '\n' +
                ", filmography=" + filmography.toString();
    }
}
