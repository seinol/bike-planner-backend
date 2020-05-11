package ch.hsr.greatnamebackend.person;

import ch.hsr.greatnamebackend.survey.Survey;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@GraphQLApi
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getSurveyParticipants(Survey survey) {
        return personRepository.getAllByAnswersContains(survey);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

}
