package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Lekce;
//import da.project.sporteezone.app.entity.User;
import da.project.sporteezone.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
@Slf4j
@RestController
@RequestMapping(path = "/api/v1/user")

public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public @ResponseBody
    List<User> users() {
        return userRepository.findAll();
    }
}

*/
