package ch.hsr.greatnamebackend.surveyelement;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurveyElementService {

    private final SurveyElementRepository surveyElementRepository;

    public SurveyElementService(SurveyElementRepository surveyElementRepository) {
        this.surveyElementRepository = surveyElementRepository;
    }

    public Optional<SurveyElement> getSurveyElementById(int surveyElementId) {
        return surveyElementRepository.findById(surveyElementId);
    }

}
