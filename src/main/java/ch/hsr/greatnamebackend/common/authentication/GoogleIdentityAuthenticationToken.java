package ch.hsr.greatnamebackend.common.authentication;

import lombok.EqualsAndHashCode;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

@EqualsAndHashCode(callSuper = false)
public final class GoogleIdentityAuthenticationToken extends AbstractAuthenticationToken {

    private final UserDetails userDetails;
    private final String token;

    public GoogleIdentityAuthenticationToken(String token) {
        super(null);
        this.userDetails = null;
        this.token = token;
        this.setAuthenticated(false);
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }
}