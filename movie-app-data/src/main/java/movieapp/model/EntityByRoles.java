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

    @Column(name = "name", length = 20000)
    @ElementCollection(targetClass = String.class)
    private Set<String> names = new LinkedHashSet<>();

    @Column(name = "ids", length = 20000)
    @ElementCollection(targetClass = Long.class)
    private Set<Long> ids = new LinkedHashSet<>();
}
