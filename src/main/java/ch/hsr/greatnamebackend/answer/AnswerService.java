package ch.hsr.greatnamebackend.answer;

import ch.hsr.greatnamebackend.person.Person;
import ch.hsr.greatnamebackend.person.PersonService;
import ch.hsr.greatnamebackend.survey.Survey;
import ch.hsr.greatnamebackend.survey.SurveyService;
import ch.hsr.greatnamebackend.surveyElement.SurveyElement;
import ch.hsr.greatnamebackend.surveyElement.SurveyElementService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@GraphQLApi
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final PersonService personService;
    private final SurveyElementService surveyElementService;
    private final SurveyService surveyService;

    public AnswerService(AnswerRepository answerRepository, PersonService personService, SurveyElementService surveyElementService, SurveyService surveyService) {
        this.answerRepository = answerRepository;
        this.personService = personService;
        this.surveyElementService = surveyElementService;
        this.surveyService = surveyService;
    }

    @GraphQLMutation(name = "saveAnswers")
    public List<Answer> saveAnswers(@NotNull @GraphQLArgument(name = "person") Person person,
                                    @NotNull @GraphQLArgument(name = "answers") List<AnswerInput> answers) {
        Person tmpPerson = person;
        if (tmpPerson.getId() == null)
            tmpPerson = personService.savePerson(person);

        List<Answer> entities = new ArrayList<>();
        for (AnswerInput input : answers) {
            Optional<SurveyElement> surveyElement = surveyElementService.getSurveyElementById(input.getSurveyElementId());
            Optional<Survey> survey = surveyService.getSurveyById(input.getSurveyId());
            Answer answer = new Answer();
            answer.setPerson(tmpPerson);
            surveyElement.ifPresent(answer::setSurveyElement);
            survey.ifPresent(answer::setSurvey);
            answer.setSelectedAnswer(input.getSelectedAnswer());
            entities.add(answer);
        }
        return answerRepository.saveAll(entities);
    }
}
