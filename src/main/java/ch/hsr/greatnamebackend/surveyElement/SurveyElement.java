package ch.hsr.greatnamebackend.surveyElement;

import ch.hsr.greatnamebackend.answer.Answer;
import ch.hsr.greatnamebackend.surveyGroup.SurveyGroup;
import io.leangen.graphql.annotations.types.GraphQLInterface;
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
@Table(name = "survey_element")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@GraphQLInterface(name = "SurveyElement", implementationAutoDiscovery = true)
public abstract class SurveyElement {
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
