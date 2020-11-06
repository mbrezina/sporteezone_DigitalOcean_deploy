package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.User;
import da.project.sporteezone.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*

@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String user(Model model, @AuthenticationPrincipal OAuth2User oauth2User) {

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

}

*/
