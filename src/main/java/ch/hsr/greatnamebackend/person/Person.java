package ch.hsr.greatnamebackend.person;

import ch.hsr.greatnamebackend.answer.Answer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Table(name = "person")
public class Person {
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
