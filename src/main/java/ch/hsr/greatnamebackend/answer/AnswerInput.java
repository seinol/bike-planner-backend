package ch.hsr.greatnamebackend.answer;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AnswerInput {

    @NotNull
    private int surveyId;

    @NotNull
    private int surveyElementId;

    @NotNull
    private String selectedAnswer;

}
