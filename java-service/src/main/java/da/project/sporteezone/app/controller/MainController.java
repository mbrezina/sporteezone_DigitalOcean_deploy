package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.service.ZakaznikService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Slf4j
@Controller
public class MainController {

    @Autowired
    private ZakaznikService zakaznikService;

    @RequestMapping("api/user")
    public ModelAndView showRate() throws IOException {

        log.info("jsem za autentikací v databázi");
        ModelAndView dataHolder = new ModelAndView("user_test");
        return dataHolder;
    }

    @RequestMapping("star")
    public ModelAndView showStar() throws IOException {
        log.info("jsem za autentikací Google/OAUTH2");
        ModelAndView dataHolder = new ModelAndView("index");
        return dataHolder;
    }

    @RequestMapping({"home", ""})
    public ModelAndView showHome() throws IOException {
        log.info("tady není žádná autentikace");
        ModelAndView dataHolder = new ModelAndView("index");
        return dataHolder;
    }

}

