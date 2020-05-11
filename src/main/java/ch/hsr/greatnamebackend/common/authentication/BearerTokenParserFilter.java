package ch.hsr.greatnamebackend.common.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class BearerTokenParserFilter extends OncePerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(BearerTokenParserFilter.class);

    private static final String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            LOG.debug("Found bearer token on request {}", request);

            String token = parseAuthorizationToken(authorizationHeader);
            GoogleIdentityAuthenticationToken googleIdentityAuthenticationToken =
                    new GoogleIdentityAuthenticationToken(token);
            SecurityContextHolder.getContext().setAuthentication(googleIdentityAuthenticationToken);
        } else {
            LOG.debug("Missing bearer token on request {}", request);
        }
        filterChain.doFilter(request, response);
    }

    private String parseAuthorizationToken(String authorizationHeader) {
        return authorizationHeader.substring(TOKEN_PREFIX.length());
    }
}
