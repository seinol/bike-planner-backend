package ch.hsr.greatnamebackend.answerGroup;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "answer_group")
public class AnswerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    // TODO: 29.03.2020 Wie funktioniert das
    /*
    @Column(name = "answer_possibilities")
    private String[] answerPossibilities;
    */
}
