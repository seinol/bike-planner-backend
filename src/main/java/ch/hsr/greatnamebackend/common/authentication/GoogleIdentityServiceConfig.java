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
    private String tokenEndpoint;

}
