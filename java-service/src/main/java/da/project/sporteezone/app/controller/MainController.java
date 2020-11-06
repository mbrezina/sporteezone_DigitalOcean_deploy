package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Fitness;
//import da.project.sporteezone.app.entity.GoogleUserInfo;
import da.project.sporteezone.app.entity.User;
//import da.project.sporteezone.app.service.CustomOidcUserService;
import da.project.sporteezone.app.service.FitnessService;
import da.project.sporteezone.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Slf4j
@Controller
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public String user(Model model,
                              @AuthenticationPrincipal OAuth2User oauth2User) {

        String subKod = oauth2User.getAttributes().get("sub").toString();
        String jmeno = oauth2User.getAttributes().get("name").toString();
        String email = oauth2User.getAttributes().get("email").toString();

        User vyhledanyUzivatel = userService.najdiPodleSub(subKod);
        if (vyhledanyUzivatel == null) {
            User novyUzivatel = new User(subKod, jmeno, email);
            userService.ulozUzivatele(novyUzivatel);
            model.addAttribute("user", novyUzivatel);
        } else {
            model.addAttribute("user", vyhledanyUzivatel);
        }
        return "user";
    }


    @RequestMapping("")
    public ModelAndView showRate() throws IOException {
        ModelAndView dataHolder = new ModelAndView("index");
        //dataHolder.addObject("message", "hello");
        return dataHolder;
    }
}

