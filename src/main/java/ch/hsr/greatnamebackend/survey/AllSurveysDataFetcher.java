package ch.hsr.greatnamebackend.survey;

import ch.hsr.greatnamebackend.survey.Survey;
import ch.hsr.greatnamebackend.survey.SurveyRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllSurveysDataFetcher implements DataFetcher<List<Survey>> {

    final
    SurveyRepository surveyRepository;

    public AllSurveysDataFetcher(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<Survey> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return surveyRepository.findAll();
    }
}
