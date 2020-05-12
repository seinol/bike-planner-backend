package ch.hsr.greatnamebackend.answergroup;

import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@TypeDef(
        name = "pgsql_enum_array",
        typeClass = EnumArrayType.class,
        defaultForType = AnswerPossibility[].class,
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = EnumArrayType.SQL_ARRAY_TYPE,
                        value = "answer_possibilities"
                )
        }
)
@Table(name = "answer_group")
public class AnswerGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Type(type = "pgsql_enum_array")
    @Column(name = "answer_possibilities", columnDefinition = "answer_possibilities[]")
    private AnswerPossibility[] answerPossibilities;

}
