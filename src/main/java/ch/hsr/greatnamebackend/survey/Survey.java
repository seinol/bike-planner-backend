package ch.hsr.greatnamebackend.survey;

import ch.hsr.greatnamebackend.answer.Answer;
import ch.hsr.greatnamebackend.surveyGroup.SurveyGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "survey")
    private Collection<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "answerGroup")
    private Collection<SurveyGroup> surveyGroups = new ArrayList<>();

    private String name;

    @Column(name = "creationdate", nullable = false)
    private Date creationDate;

    @Column(name = "finishby")
    private Date finishBy;

    private String area;
}
