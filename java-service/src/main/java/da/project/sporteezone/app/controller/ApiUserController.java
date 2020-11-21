package da.project.sporteezone.app.controller;


import da.project.sporteezone.app.entity.Apiuser;
import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.repository.ApiuserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
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
