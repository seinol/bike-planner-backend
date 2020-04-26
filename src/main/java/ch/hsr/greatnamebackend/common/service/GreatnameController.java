package ch.hsr.greatnamebackend.common.service;

import graphql.ExecutionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(GreatnameController.COLLECTION_PATH)
public class GreatnameController {

    public static final String COLLECTION_PATH = "/survey";

    final
    GraphQLService graphQLService;

    public GreatnameController(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    // TODO: 26.04.2020 GraphiGL explorer 
    
    @PostMapping
    public ResponseEntity<Object> getSurveys(@RequestBody String query) {
        ExecutionResult executionResult = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }
}

