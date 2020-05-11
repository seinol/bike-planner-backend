package ch.hsr.greatnamebackend.common.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
@ConditionalOnMissingBean(type = "GoogleIdentityServiceClient")
public class GoogleIdentityServiceClient {

    private static final Logger LOG = LoggerFactory.getLogger(GoogleIdentityServiceClient.class);

    private final GoogleIdentityServiceConfig googleIdentityServiceConfig;
    private final RestTemplate restTemplate;

    public GoogleIdentityServiceClient(GoogleIdentityServiceConfig googleIdentityServiceConfig, RestTemplateBuilder restTemplateBuilder) {
        this.googleIdentityServiceConfig = googleIdentityServiceConfig;
        this.restTemplate = restTemplateBuilder.build();
    }

    public GoogleIdentityToken getUserInfo(String code) {
        LOG.debug("TokenEndpoint: {}", googleIdentityServiceConfig.getTokenEndpoint());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", String.format("Basic %s",
                Base64Utils.encodeToString(String
                        .format("%s:%s", googleIdentityServiceConfig.getClientId(),
                                googleIdentityServiceConfig.getClientSecret()).getBytes())));

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("response_type", "token");
        formData.add("code", code);
        //TODO more form data needed?
        // also validate/check GoogleIdentityToken!

        return getToken(headers, formData);
    }

    private GoogleIdentityToken getToken(HttpHeaders headers, MultiValueMap<String, String> formData) {
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        try {
            return restTemplate.postForEntity(googleIdentityServiceConfig.getTokenEndpoint(), request,
                    GoogleIdentityToken.class).getBody();
        } catch (HttpStatusCodeException e) {
            LOG.debug("HttpStatusCodeException Response Body: {}", e.getResponseBodyAsString());
            switch (e.getStatusCode()) {
                case BAD_REQUEST:
                    LOG.debug("Bad request: code: {}, redirect_uri: {}", formData.get("code"),
                            formData.get("redirect_uri"));
                    return null;
                case UNAUTHORIZED:
                    LOG.debug("Bad clientId / clientSecret combination provided");
                    return null;
                default:
                    throw e;

            }
        }
    }


}
