package ch.hsr.greatnamebackend.survey;

import ch.hsr.greatnamebackend.answer.Answer;
import ch.hsr.greatnamebackend.surveyGroup.SurveyGroup;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id", description = "A survey's id")
    private Integer id;

    @OneToMany(mappedBy = "survey")
    private Collection<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "answerGroup")
    private Collection<SurveyGroup> surveyGroups = new ArrayList<>();

    @GraphQLQuery(name = "name", description = "A survey's name")
    private String name;

    @Column(name = "creationdate", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "finishby")
    private LocalDateTime finishBy;

    private String area;
}