package da.project.sporteezone.app.controller;

import ch.qos.logback.classic.Logger;
import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.repository.FitnessRepository;
import da.project.sporteezone.app.service.FitnessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/fitness")
public class FitnessController {

    @Autowired
    private FitnessService fitnessService;

    @GetMapping(path = "")
    public @ResponseBody
    List<Fitness> getAllFitness() {
        return fitnessService.zobrazVsechnyFitness();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Fitness> getJednoFitko(@PathVariable Integer id) {
        return fitnessService.najdiFitko(id);
    }

    @PostMapping(path = "/addOne", consumes = "application/json")
    public @ResponseBody
    Fitness pridejJednoFitko(@RequestBody Fitness noveFitness) {
        fitnessService.pridejJednoFitko(noveFitness);
        return noveFitness;
    }

    @PostMapping(path = "/addMore", consumes = "application/json")
    public @ResponseBody
    List<Fitness> pridejVicFitek(@RequestBody List<Fitness> novaFitka) {
        fitnessService.pridejVicFitek(novaFitka);
        return novaFitka;
    }
}

