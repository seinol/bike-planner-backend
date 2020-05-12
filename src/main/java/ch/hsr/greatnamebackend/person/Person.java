package ch.hsr.greatnamebackend.person;

import ch.hsr.greatnamebackend.answer.Answer;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "person")
public class Person {

    public Person(Integer id, String lastname, String firstname, String mail) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.mail = mail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "person")
    private Collection<Answer> answers = new ArrayList<>();

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "mail")
    private String mail;

}
