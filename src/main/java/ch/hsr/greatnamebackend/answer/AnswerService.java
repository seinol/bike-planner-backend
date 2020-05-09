package ch.hsr.greatnamebackend.answer;

import ch.hsr.greatnamebackend.survey.Survey;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@GraphQLApi
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAnswerToSurvey(Survey survey) {
        return answerRepository.findAllBySurvey(survey);
    }
}
