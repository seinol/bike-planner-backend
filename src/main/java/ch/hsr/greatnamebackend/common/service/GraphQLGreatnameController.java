package ch.hsr.greatnamebackend.common.service;

import ch.hsr.greatnamebackend.survey.SurveyService;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.geantyref.GenericTypeReflector;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.annotations.types.GraphQLInterface;
import io.leangen.graphql.generator.mapping.strategy.InterfaceMappingStrategy;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import io.leangen.graphql.util.ClassUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.AnnotatedType;
import java.util.*;

@RestController
public class GraphQLGreatnameController {

    private final GraphQL graphQL;
    private static final String GRAPHQL_ENDPOINT = "/graphql";

    public GraphQLGreatnameController(SurveyService surveyService) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withInterfaceMappingStrategy(new InterfaceMappingStrategy() {
                    @Override
                    public boolean supports(AnnotatedType annotatedType) {
                        return annotatedType.isAnnotationPresent(GraphQLInterface.class);
                    }

                    @Override
                    public Collection<AnnotatedType> getInterfaces(AnnotatedType type) {
                        Class cls = ClassUtils.getRawType(type.getType());
                        Set<AnnotatedType> interfaces = new HashSet<>();
                        do {
                            AnnotatedType currentType = GenericTypeReflector.getExactSuperType(type, cls);
                            if (supports(currentType)) {
                                interfaces.add(currentType);
                            }
                            Arrays.stream(cls.getInterfaces())
                                    .map(inter -> GenericTypeReflector.getExactSubType(type, inter))
                                    .filter(this::supports)
                                    .forEach(interfaces::add);
                        } while ((cls = cls.getSuperclass()) != Object.class && cls != null);
                        return interfaces;
                    }
                })
                .withResolverBuilders(
                        new AnnotatedResolverBuilder())
                .withOperationsFromSingleton(surveyService)
                .withValueMapperFactory(
                        new JacksonValueMapperFactory())
                .generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    @PostMapping(value = GRAPHQL_ENDPOINT, consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
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
