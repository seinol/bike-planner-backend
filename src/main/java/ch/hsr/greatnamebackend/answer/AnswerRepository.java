package ch.hsr.greatnamebackend.answer;

import ch.hsr.greatnamebackend.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findAllBySurvey(Survey survey);
}
