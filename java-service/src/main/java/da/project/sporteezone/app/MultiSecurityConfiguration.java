package da.project.sporteezone.app;

//import da.project.sporteezone.app.service.ApiUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
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

import java.util.HashSet;
import java.util.Set;

@EnableWebSecurity
public class MultiSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        protected void configure(HttpSecurity http) throws Exception {
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "api/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
                .and()
                .httpBasic();
        }
        
        @Override
        public UserDetailsService userDetailsServiceBean() throws Exception {
            return super.userDetailsServiceBean();
        }
        
        /*
        @Bean
        DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
            daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
            return daoAuthenticationProvider;
        }
        */

        //pro SpringBoot 2 a vyšší je potřeba password encoder a je třeba ho použít pro zakódování hesel uživatelů
        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();

        }
    }

    @Order(2)
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
                .authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers("/star/**").authenticated())
                .oauth2Login(oauthLogin -> oauthLogin
                    .userInfoEndpoint()
                    .oidcUserService(googleUserService))
                .authorizeRequests().antMatchers("/guest/**", "/logout/**").permitAll();
        }
    }
}
