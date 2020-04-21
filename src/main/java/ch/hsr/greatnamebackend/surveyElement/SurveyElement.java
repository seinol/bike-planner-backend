package ch.hsr.greatnamebackend.surveyElement;

import ch.hsr.greatnamebackend.answer.Answer;
import ch.hsr.greatnamebackend.surveyGroup.SurveyGroup;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "survey_element")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class SurveyElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "survey_group_id")
    private SurveyGroup surveyGroup;

    @OneToMany(mappedBy = "surveyElement")
    private Collection<Answer> answers = new ArrayList<>();

    @Column(name = "position")
    private int position;

    @Column(name = "type")
    private String type;
}
