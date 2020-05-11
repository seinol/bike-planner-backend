package ch.hsr.greatnamebackend.common.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;

public final class GoogleIdentityAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(GoogleIdentityAuthenticationProvider.class);

    private final GoogleIdentityServiceClient googleIdentityServiceClient;

    public GoogleIdentityAuthenticationProvider(GoogleIdentityServiceClient googleIdentityServiceClient) {
        this.googleIdentityServiceClient = googleIdentityServiceClient;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String token = authentication.getCredentials().toString();

        LOG.debug("Authentication in Progress");

        //TODO implement authentication here... validate token with google endpoints!!
        // Is it necessary to do this with userInfo fetching? Find better solution

/*        GoogleIdentityToken googleIdentityUserInfo = googleIdentityServiceClient.getUserInfo(token);

        if (googleIdentityUserInfo == null) {
            throw new BadCredentialsException("Invalid bearer token provided");
        }*/

        return new GoogleIdentityAuthenticationToken(token);
    }

    @Override
    public boolean supports(Class<?> authorization) {
        return GoogleIdentityAuthenticationToken.class.isAssignableFrom(authorization);
    }
}

