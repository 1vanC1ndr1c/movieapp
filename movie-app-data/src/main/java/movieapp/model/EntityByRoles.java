package movieapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data

@Entity
@Table(name = "entityByRoles")
public class EntityByRoles extends BaseEntity {

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Lob
    @Column(name = "name")
    @ElementCollection(targetClass = String.class)
    private Set<String> names = new LinkedHashSet<>();

    @Lob
    @Column(name = "ids")
    @ElementCollection(targetClass = Long.class)
    private Set<Long> ids = new LinkedHashSet<>();
}
