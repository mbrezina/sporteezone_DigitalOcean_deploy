package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.GoogleUserInfo;
import da.project.sporteezone.app.entity.User;
import da.project.sporteezone.app.service.CustomOidcUserService;
import da.project.sporteezone.app.service.FitnessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Slf4j
@Controller
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    CustomOidcUserService customOidcUserService;

    //@Autowired
    //private FitnessService fitnessService;

    @RequestMapping("")
    public ModelAndView showRate() throws IOException {
        ModelAndView dataHolder = new ModelAndView("index");
        log.info("jsem v '/'");
        //dataHolder.addObject("message", "hello");
        return dataHolder;
    }

    @RequestMapping("user")
    public ModelAndView showUser(@AuthenticationPrincipal CustomOidcUserService principal) throws IOException {
        ModelAndView dataHolder = new ModelAndView("user");
        //User user = customOidcUserService.
        dataHolder.addObject("message", "kuk");
        return dataHolder;
    }

}

