package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Fitness;

//import da.project.sporteezone.app.entity.ApiUser;

import da.project.sporteezone.app.entity.Zakaznik;
import da.project.sporteezone.app.service.FitnessService;
//import da.project.sporteezone.app.service.UserPrincipalDetailsService;
import da.project.sporteezone.app.service.ZakaznikService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
//@RequestMapping(path = "/user")
public class MainController {

    @Autowired
    private ZakaznikService zakaznikService;

    @RequestMapping("api/user")
    public ModelAndView showRate() throws IOException {
        log.info("jsem zde");
        ModelAndView dataHolder = new ModelAndView("user_test");
        return dataHolder;
    }


//    @RequestMapping("")
//    public String user(Model model, @AuthenticationPrincipal OAuth2User oauth2User) {
//        String subKod = oauth2User.getAttributes().get("sub").toString();
//        String jmeno = oauth2User.getAttributes().get("name").toString();
//        String email = oauth2User.getAttributes().get("email").toString();
//        //na Long:
//        //Long sub = Long.valueOf(subKod);
//        
//        Zakaznik vyhledanyZakaznik = zakaznikService.najdiPodleSub(subKod);
//        if (vyhledanyZakaznik == null) {
//            Zakaznik novyZakaznik = new Zakaznik(subKod, jmeno, email);
//            zakaznikService.ulozUzivatele(novyZakaznik);
//            model.addAttribute("user", novyZakaznik);
//        } else {
//            model.addAttribute("user", vyhledanyZakaznik);
//        }
//        return "user";
//        
//    }

//    @RequestMapping("")
//    public ModelAndView showRate() throws IOException {
//        ModelAndView dataHolder = new ModelAndView("index");
//        //dataHolder.addObject("message", "hello");
//        return dataHolder;
//    }
}

