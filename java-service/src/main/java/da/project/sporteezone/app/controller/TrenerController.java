package da.project.sporteezone.app.controller;


import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.entity.Trener;
import da.project.sporteezone.app.repository.TrenerRepository;
import da.project.sporteezone.app.service.LekceService;
import da.project.sporteezone.app.service.TrenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/trener")

public class TrenerController {

    @Autowired
    private TrenerService trenerService;

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Trener> najdiTrenera(@PathVariable Integer id) {
        //vrací trenéra včetně lekcí, které vede
        return trenerService.najdiTrenera(id);
    }

}

