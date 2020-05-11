package ch.hsr.greatnamebackend.survey;

import ch.hsr.greatnamebackend.person.Person;
import ch.hsr.greatnamebackend.person.PersonService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@GraphQLApi
@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final PersonService personService;

    public SurveyService(SurveyRepository surveyRepository, PersonService personService) {
        this.surveyRepository = surveyRepository;
        this.personService = personService;
    }

    @GraphQLQuery(name = "surveys")
    public List<Survey> getSurveys() {
        return surveyRepository.findAll();
    }

    @GraphQLQuery(name = "survey")
    public Optional<Survey> getSurveyById(@GraphQLArgument(name = "id") Integer id) {
        return surveyRepository.findById(id);
    }

    @GraphQLQuery(name = "surveyByUrlHash")
    public Optional<Survey> getSurveyByUrlHash(@GraphQLArgument(name = "urlHash") String urlHash) {
        return surveyRepository.findFirstByUrlHash(urlHash);
    }

    @GraphQLQuery(name = "participants")
    public List<Person> getParticipants(@GraphQLContext Survey survey) {
        return personService.getSurveyParticipants(survey);
    }

    /*
    @GraphQLMutation(name = "saveSurvey")
    public Survey saveSurvey(@GraphQLArgument(name = "survey") Survey survey) {
        survey.setCreationDate(LocalDateTime.now());
        return surveyRepository.save(survey);
    }
     */
}
