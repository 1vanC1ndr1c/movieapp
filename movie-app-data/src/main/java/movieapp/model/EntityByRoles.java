package movieapp.model;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Data
public class EntityByRoles extends BaseEntity {

    private Role role;
    private Set<String> names = new LinkedHashSet<>();
    private Set<Long> ids = new LinkedHashSet<>();

}
