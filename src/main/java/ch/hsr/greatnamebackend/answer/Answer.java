package ch.hsr.greatnamebackend.answer;

import ch.hsr.greatnamebackend.person.Person;
import ch.hsr.greatnamebackend.survey.Survey;
import ch.hsr.greatnamebackend.surveyElement.SurveyElement;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id", description = "A answers's id")
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
    @GraphQLQuery(name = "selectedAnswer", description = "selected answer")
    private String selectedAnswer;
}
