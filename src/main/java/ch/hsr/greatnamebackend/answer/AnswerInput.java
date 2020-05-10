package ch.hsr.greatnamebackend.answer;

import ch.hsr.greatnamebackend.answerGroup.AnswerPossibility;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AnswerInput {
    @NotNull
    private int surveyId;
    @NotNull
    private int surveyElementId;
    @NotNull
    private AnswerPossibility selectedAnswer;
}
