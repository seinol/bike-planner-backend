package ch.hsr.greatnamebackend.config;

import ch.hsr.greatnamebackend.common.authentication.BearerTokenParserFilter;
import ch.hsr.greatnamebackend.common.authentication.GoogleIdentityAuthenticationProvider;
import ch.hsr.greatnamebackend.common.authentication.GoogleIdentityServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@Order(1)
public class SecurityOAuthConfig extends WebSecurityConfigurerAdapter {

    private final GoogleIdentityAuthenticationProvider googleIdentityAuthenticationProvider;

    public SecurityOAuthConfig(GoogleIdentityServiceConfig googleIdentityServiceConfig) {
        this.googleIdentityAuthenticationProvider =
                new GoogleIdentityAuthenticationProvider(googleIdentityServiceConfig);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable()
                .addFilterBefore(new BearerTokenParserFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(patternify("/graphql")).authenticated()
                .antMatchers(patternify("/graphiql")).authenticated()
                .anyRequest().authenticated();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    private String patternify(String path) {
        return path + "/**";
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(googleIdentityAuthenticationProvider);
    }

}