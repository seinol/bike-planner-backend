package ch.hsr.greatnamebackend.common.authentication;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConditionalOnMissingBean(type = "GoogleIdentityServiceConfig")
public class GoogleIdentityServiceConfig {

    @Value("${security.oauth2.client.userAuthorizationUri}")
    private String authorizationEndpoint;

    @Value("${security.oauth2.client.clientId}")
    private String clientId;

    @Value("${security.oauth2.client.clientSecret}")
    private String clientSecret;

    @Value("${security.oauth2.client.accessTokenUri}")
    private String accessTokenValidity;

    @Value("${security.oauth2.client.userAuthorizationUri}")
    private String tokenEndpoint;

    @Value("${security.oauth2.resource.userInfoUri}")
    private String userInfoEndpoint;

    @Value("${security.oauth2.client.tokenName}")
    private String tokenName;

    @Value("${security.oauth2.client.authenticationScheme}")
    private String clientAuthenticationScheme;

    @Value("${security.oauth2.client.scope}")
    private String scope;

/*    @Value("${cis.checkTokenEndpoint}")
    private String checkTokenEndpoint;

    @Value("${cis.logoutEndpoint}")
    private String logoutEndpoint;

    @Value("${cis.redirectUris}")
    private String redirectUris;

    @Value("${cis.grantTypes}")
    private String grantTypes;*/

}
