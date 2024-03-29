package da.project.sporteezone.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import java.util.HashSet;
import java.util.Set;

@EnableWebSecurity
public class TwoTypeSecurityConfiguration {
    @Configuration
    @Order(2)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/**")
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/fitko/addMore").hasAuthority("ADMIN")
                //for testing of authentication:
                //.antMatchers(HttpMethod.GET, "/api/**").hasAuthority("ADMIN")
                .and()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint()); }
        @Bean
        public AuthenticationEntryPoint authenticationEntryPoint(){
            BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
            entryPoint.setRealmName("admin realm");
            return entryPoint; }
        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        } }
    @Configuration
    public static class Oauth2WebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            Set<String> googleScopes = new HashSet<>();
            googleScopes.add("https://www.googleapis.com/auth/userinfo.email");
            googleScopes.add("https://www.googleapis.com/auth/userinfo.profile");
            OidcUserService googleUserService = new OidcUserService();
            googleUserService.setAccessibleScopes(googleScopes);
            http
                .oauth2Login(oauthLogin -> oauthLogin
                    .userInfoEndpoint()
                    .oidcUserService(googleUserService))
                .authorizeRequests().antMatchers("/allstar/**").authenticated()
                .anyRequest().permitAll();
        }
    }
}
