package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.repository.PrefRepository;
import da.project.sporteezone.app.service.LekceService;
import da.project.sporteezone.app.service.PrefService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/pref")
public class PreferenceController {

    @Autowired
    private PrefService prefService;

    @GetMapping(path = "/{sub}")
    public @ResponseBody
    List<String> vsechnyLekce(@PathVariable String sub) {
        return prefService.getSeznamPreferenci(sub);
    }

    @GetMapping("/isUserAuthenticated")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

}

