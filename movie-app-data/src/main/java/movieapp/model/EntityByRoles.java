package movieapp.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class EntityByRoles<T extends BaseEntity> extends BaseEntity {

    private Role role;
    private List<T> list = new ArrayList<>();

    @Override
    public String toString() {
        return "role=" + role +
                ", list=" + list.toString() +
                '}';
    }
}
