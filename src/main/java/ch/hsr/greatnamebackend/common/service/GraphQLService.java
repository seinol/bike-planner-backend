package ch.hsr.greatnamebackend.common.service;

import ch.hsr.greatnamebackend.survey.AllSurveysDataFetcher;
import ch.hsr.greatnamebackend.survey.SurveyDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLService {

    @Value("classpath:greatname.graphql")
    Resource resource;

    private GraphQL graphQL;

    private final AllSurveysDataFetcher allSurveysDataFetcher;
    private final SurveyDataFetcher surveyDataFetcher;

    public GraphQLService(AllSurveysDataFetcher allSurveysDataFetcher, SurveyDataFetcher surveyDataFetcher) {
        this.allSurveysDataFetcher = allSurveysDataFetcher;
        this.surveyDataFetcher = surveyDataFetcher;
    }

    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allSurveys", allSurveysDataFetcher)
                        .dataFetcher("survey", surveyDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
