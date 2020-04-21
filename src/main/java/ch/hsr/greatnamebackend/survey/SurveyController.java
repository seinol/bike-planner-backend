package ch.hsr.greatnamebackend.survey;

import ch.hsr.greatnamebackend.common.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(SurveyController.COLLECTION_PATH)
public class SurveyController {

    public static final String COLLECTION_PATH = "/survey";
    private static final String RESOURCE_SUBPATH = "{id}";
    public static final String RESOURCE_PATH = COLLECTION_PATH + "/" +  RESOURCE_SUBPATH;

    final
    GraphQLService graphQLService;

    public SurveyController(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    @PostMapping
    public ResponseEntity<Object> getSurveys(@RequestBody String query) {
        ExecutionResult executionResult = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }
}
