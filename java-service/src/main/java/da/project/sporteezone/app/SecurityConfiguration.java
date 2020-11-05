package da.project.sporteezone.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        Set<String> googleScopes = new HashSet<>();
        googleScopes.add("https://www.googleapis.com/auth/userinfo.email");
        googleScopes.add("https://www.googleapis.com/auth/userinfo.profile");

        OidcUserService googleUserService = new OidcUserService();
        googleUserService.setAccessibleScopes(googleScopes);

        http
            .authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers("/user/**").authenticated())
            .oauth2Login(oauthLogin -> oauthLogin
                .userInfoEndpoint()
                .oidcUserService(googleUserService))
            .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .antMatchers(HttpMethod.GET, "/api/**").permitAll()
            .antMatchers(HttpMethod.POST, "/api/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .logout()
            .logoutSuccessHandler(oidcLogoutSuccessHandler())
            .invalidateHttpSession(true)
            .clearAuthentication(true);

    }

    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
            new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);

        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}");

        return oidcLogoutSuccessHandler;
    }


    //pro SpringBoot 2 a vyšší je potřeba password encoder a je třeba ho použít pro zakódování hesel uživatelů
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
