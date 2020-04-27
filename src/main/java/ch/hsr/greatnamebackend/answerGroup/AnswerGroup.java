package ch.hsr.greatnamebackend.answerGroup;

import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "answer_group")
public class AnswerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Type(type = "ch.hsr.greatnamebackend.util.GenericArrayUserType")
    @Column(name = "answer_possibilities")
    private String[] answerPossibilities;
}
