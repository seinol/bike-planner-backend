package ch.hsr.greatnamebackend.survey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    List<Survey> findAllByName(String name);
}
