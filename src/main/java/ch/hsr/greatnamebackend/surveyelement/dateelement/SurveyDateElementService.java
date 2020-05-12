package ch.hsr.greatnamebackend.surveyelement.dateelement;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@GraphQLApi
@Service
public class SurveyDateElementService {

    private final SurveyDateElementRepository surveyDateElementRepository;

    public SurveyDateElementService(SurveyDateElementRepository surveyDateElementRepository) {
        this.surveyDateElementRepository = surveyDateElementRepository;
    }

    @GraphQLQuery(name = "surveyDateElements")
    public List<SurveyDateElement> getDateElements(List<Integer> ids) {
        return surveyDateElementRepository.findAllById(ids);
    }

    @GraphQLQuery(name = "surveyDateElement")
    public Optional<SurveyDateElement> getDateElement(Integer id) {
        return surveyDateElementRepository.findById(id);
    }

}
