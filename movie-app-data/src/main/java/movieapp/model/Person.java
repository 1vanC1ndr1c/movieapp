package movieapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Person extends BaseEntity {

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "roles")
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Person.class)
    private String[] roles;

    @Column(name = "bio")
    private String bio;

    @JoinColumn(name = "birth_date")
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Person.class)
    @ElementCollection(targetClass = CustomDate.class)
    private CustomDate birthDate = new CustomDate();

    @Column(name = "birthPlace")
    private String birthPlace;

    @Column(name = "filmography")
    private String filmography;

    @Builder//can't use allargs because of super()
    public Person(Long id, String name, String[] roles, String bio, CustomDate birthDate, String birthPlace, String filmography) {
        super(id);
        this.name = name;
        this.roles = roles;
        this.bio = bio;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.filmography = filmography;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' + "\n" +
                ", roles=" + Arrays.toString(roles) + "\n" +
                ", bio='" + bio + '\'' + "\n" +
                ", birthDate=" + birthDate + "\n" +
                ", birthPlace='" + birthPlace + '\'' + "\n" +
                ", filmography='" + filmography + '\'' + "\n" +
                '}';
    }
}
