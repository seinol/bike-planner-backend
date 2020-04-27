package ch.hsr.greatnamebackend.surveyElement.dateElement;

import ch.hsr.greatnamebackend.surveyElement.SurveyElement;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "survey_date_element")
@DiscriminatorValue("DATE")
public class SurveyDateElement extends SurveyElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;
}
