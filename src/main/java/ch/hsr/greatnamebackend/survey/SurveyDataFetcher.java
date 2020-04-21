package ch.hsr.greatnamebackend.survey;

import ch.hsr.greatnamebackend.survey.Survey;
import ch.hsr.greatnamebackend.survey.SurveyRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class SurveyDataFetcher implements DataFetcher<Survey> {

    final
    SurveyRepository surveyRepository;

    public SurveyDataFetcher(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey get(DataFetchingEnvironment dataFetchingEnvironment) {
        Integer id = Integer.valueOf(dataFetchingEnvironment.getArgument("id"));
        return surveyRepository.findById(id).orElse(null);
    }
}
