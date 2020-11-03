package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.GoogleUserInfo;
import da.project.sporteezone.app.entity.User;
import da.project.sporteezone.app.repository.UserRepository;
import lombok.Data;
//import jdk.internal.org.jline.utils.Log;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CustomOidcUserService extends OidcUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);

        try {
            return processOidcUser(userRequest, oidcUser);
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OidcUser processOidcUser(OidcUserRequest userRequest, OidcUser oidcUser) {
        GoogleUserInfo googleUserInfo = new GoogleUserInfo(oidcUser.getAttributes());

        Optional<User> userOptional = userRepository.findByEmail(googleUserInfo.getEmail());
        if (!userOptional.isPresent()) {
            User user = new User();
            user.setEmail(googleUserInfo.getEmail());
            user.setName(googleUserInfo.getName());
            user.setSub(googleUserInfo.getId());
            userRepository.save(user);
        }
        return oidcUser;
    }


}
