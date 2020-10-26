package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.repository.LekceRepository;
import da.project.sporteezone.app.repository.TrenerRepository;
import da.project.sporteezone.app.service.LekceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/lekce")
public class LekceController {

    @Autowired
    private LekceService lekceService;

    @Autowired
    private LekceRepository lekceRepository;

    @Autowired
    private TrenerRepository lektorRepository;

    @GetMapping(path = "")
    public @ResponseBody
    List<Lekce> vsechnyLekce() {
        return lekceService.zobrazVsechnyLekce();
    }

    @GetMapping(path = "/byDatum")
    public @ResponseBody
    List<Lekce> findLekceByDateTime(
        @RequestParam("zacatek")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime zacatek,
        @RequestParam("konec")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime konec) {
        log.debug("datum je " + zacatek);
        log.debug(String.valueOf(zacatek.getClass()));
        return lekceService.najdiLekce(zacatek, konec);
    }

    @PostMapping(path = "/addOne", consumes = "application/json")
    public @ResponseBody
    Lekce pridejJednuLekci(@RequestBody Lekce novaLekce) {
        lekceService.pridejJednuLekci(novaLekce);
        return novaLekce;
    }

    @PostMapping(path = "/addMore", consumes = "application/json")
    public @ResponseBody
    List<Lekce> pridejVicLekci(@RequestBody List<Lekce> noveLekce) {
        lekceService.pridejVicLekci(noveLekce);
        return noveLekce;
    }

}

