package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.service.FitnessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
//@RequestMapping(path = "/")
public class MainController {

    @Autowired
    private FitnessService fitnessService;

    @RequestMapping("/")
    public ModelAndView showRate() throws IOException {
        ModelAndView dataHolder = new ModelAndView("index");
        dataHolder.addObject("message", "hello");
        return dataHolder;
    }

    @RequestMapping("/restricted")
    public ModelAndView showRestricted() throws IOException {
        ModelAndView dataHolder = new ModelAndView("restricted");
        dataHolder.addObject("message", "restricted");
        return dataHolder;
    }
}

