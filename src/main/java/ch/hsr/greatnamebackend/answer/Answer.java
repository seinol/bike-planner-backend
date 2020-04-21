package ch.hsr.greatnamebackend.answer;

import ch.hsr.greatnamebackend.person.Person;
import ch.hsr.greatnamebackend.survey.Survey;
import ch.hsr.greatnamebackend.surveyElement.SurveyElement;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "survey_element_id")
    private SurveyElement surveyElement;

    @Column(name = "selected_answer")
    private String selectedAnswer;
}
