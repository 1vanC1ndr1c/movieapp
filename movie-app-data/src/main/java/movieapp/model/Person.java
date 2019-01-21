package movieapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Person extends BaseEntity {

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "roles")
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Person.class)
    private List<String> roles = new ArrayList<>();

    @Column(name = "bio")
    private String bio;

    private Date born = new Date();

    @Column(name = "birthPlace")
    private String birthPlace;

    @Column(name = "filmography")
    private String filmography;

    public Person(Long id, String name, List<String> roles, String bio, Date born, String birthPlace, String filmography) {
        super(id);
        this.name = name;
        this.roles = roles;
        this.bio = bio;
        this.born = born;
        this.birthPlace = birthPlace;
        this.filmography = filmography;
    }
}
