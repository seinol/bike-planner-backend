package ch.hsr.greatnamebackend.surveyelement.dateelement;

import ch.hsr.greatnamebackend.answer.Answer;
import ch.hsr.greatnamebackend.surveyelement.SurveyElement;
import ch.hsr.greatnamebackend.surveygroup.SurveyGroup;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "survey_date_element")
@DiscriminatorValue("DATE")
public class SurveyDateElement extends SurveyElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;

    // TODO: 10.05.2020 getter/setter nach update auf graphql-spqr-spring-boot-starter 0.0.5 entfernen
    public SurveyGroup getSurveyGroup() {
        return super.getSurveyGroup();
    }

    public void setSurveyGroup(SurveyGroup surveyGroup) {
        super.setSurveyGroup(surveyGroup);
    }

    public Collection<Answer> getAnswers() {
        return super.getAnswers();
    }

    public void setAnswers(List<Answer> answers) {
        super.setAnswers(answers);
    }

    public int getPosition() {
        return super.getPosition();
    }

    public void setPosition(int position) {
        super.setPosition(position);
    }

    public String getType() {
        return super.getType();
    }

    public void setType(String type) {
        super.setType(type);
    }

}
