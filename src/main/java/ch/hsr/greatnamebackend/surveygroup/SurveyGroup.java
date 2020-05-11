package ch.hsr.greatnamebackend.surveygroup;

import ch.hsr.greatnamebackend.answergroup.AnswerGroup;
import ch.hsr.greatnamebackend.survey.Survey;
import ch.hsr.greatnamebackend.surveyelement.SurveyElement;
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
@Table(name = "survey_group")
public class SurveyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "answer_group_id")
    private AnswerGroup answerGroup;

    @ManyToOne(optional = false)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "surveyGroup")
    private Collection<SurveyElement> surveyElements = new ArrayList<>();

    @Column(name = "part")
    private int part;

}
