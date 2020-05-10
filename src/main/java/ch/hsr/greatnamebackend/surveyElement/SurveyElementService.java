package ch.hsr.greatnamebackend.surveyElement;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurveyElementService {

    private final SurveyElementRepository surveyElementRepository;

    public SurveyElementService(SurveyElementRepository surveyElementRepository) {
        this.surveyElementRepository = surveyElementRepository;
    }


    public Optional<SurveyElement> getSurveyElementById(int surveElementId) {
        return surveyElementRepository.findById(surveElementId);
    }
}
