package ch.hsr.greatnamebackend.survey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    List<Survey> findAllByName(String name);
    Optional<Survey> findFirstByUrlHash(String urlHash);
}
