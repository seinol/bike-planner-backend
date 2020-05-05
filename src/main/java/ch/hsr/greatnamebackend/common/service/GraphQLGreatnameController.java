package ch.hsr.greatnamebackend.common.service;

import ch.hsr.greatnamebackend.survey.SurveyService;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class GraphQLGreatnameController {

    private final GraphQL graphQL;
    private final String graphQLEndpoint = "/graphql";

    public GraphQLGreatnameController(SurveyService surveyService) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withResolverBuilders(
                        new AnnotatedResolverBuilder())
                .withOperationsFromSingleton(surveyService)
                .withValueMapperFactory(
                        new JacksonValueMapperFactory())
                .generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    @PostMapping(value = graphQLEndpoint, consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
    @ResponseBody
    public Map<String, Object> graphql(@RequestBody Map<String, String> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(
                ExecutionInput.newExecutionInput()
                        .query(request.get("query"))
                        .operationName(request.get("operationName"))
                        .context(raw)
                        .build());
        return executionResult.toSpecification();
    }
}
