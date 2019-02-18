package movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Serializable = turning objects into bytes
@MappedSuperclass//other classes will be inheriting this class, but we don't need this one specifically
//this object will not be created in DB, other entities will inherit it
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}
