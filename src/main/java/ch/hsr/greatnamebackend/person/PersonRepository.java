package ch.hsr.greatnamebackend.person;

import ch.hsr.greatnamebackend.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select new ch.hsr.greatnamebackend.person.Person(p.id, p.lastname, p.firstname, p.mail)"
    + "from Answer a left join a.person p where a.survey =:survey group by p.id")
    List<Person> getAllByAnswersContains(Survey survey);

}
