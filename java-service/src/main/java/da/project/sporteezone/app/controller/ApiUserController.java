package da.project.sporteezone.app.controller;


import da.project.sporteezone.app.entity.Apiuser;
import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.repository.ApiuserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "http://sporteezone.na-webu.info", maxAge = 3600)
@RequestMapping(path = "/api/v1/apiUser")

public class ApiUserController {

    @Autowired
    ApiuserRepository apiuserRepository;

    @GetMapping("")
    public @ResponseBody
    List<Apiuser> users() {
        return apiuserRepository.findAll();
    }
}
