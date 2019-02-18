package movieapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data

@Entity
@Table(name = "entityByRoles")
/*
This class is used to link movies with persons and vice versa.
It uses a set called 'names' to quickly give access to a movie of a person name and
a set called ids that contains all the ids of a person's filmography or all the ids of people that work on a movie on a
specific personRole.
 */
public class EntityByRoles extends BaseEntity {

    @Column(name = "personRole")
    @Enumerated(value = EnumType.STRING)
    private PersonRole personRole;

    @Lob
    @Column(name = "name")
    @ElementCollection(targetClass = String.class)
    private Set<String> names = new LinkedHashSet<>();

    @Lob
    @Column(name = "ids")
    @ElementCollection(targetClass = Long.class)
    private Set<Long> ids = new LinkedHashSet<>();
}
