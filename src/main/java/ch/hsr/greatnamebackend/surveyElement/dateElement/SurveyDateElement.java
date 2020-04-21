package ch.hsr.greatnamebackend.surveyElement.dateElement;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "survey_date_element")
@DiscriminatorValue("DATE")
public class SurveyDateElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;
}
