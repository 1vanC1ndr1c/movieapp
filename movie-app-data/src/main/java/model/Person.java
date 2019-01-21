package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Person extends BaseEntity {

    private String name;
    private List<String> roles =  new ArrayList<>();
    private String bio;
    private Date born = new Date();
    private String birthPlace;
    private String filmography;

    public Person(Long id,String name, List<String> roles, String bio, Date born, String birthPlace, String filmography) {
        super(id);
        this.name = name;
        this.roles = roles;
        this.bio = bio;
        this.born = born;
        this.birthPlace = birthPlace;
        this.filmography = filmography;
    }
}
