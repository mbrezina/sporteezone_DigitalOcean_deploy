package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.entity.Trener;
import da.project.sporteezone.app.repository.LekceRepository;
import da.project.sporteezone.app.repository.TrenerRepository;
import da.project.sporteezone.app.service.LekceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/lekce")
public class LekceController {

    @Autowired
    private LekceService lekceService;

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
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime konec,
        @RequestParam(required = false) List<String> hledaneKategorie) {

        log.info("hledané kategorie jsou: " + hledaneKategorie);
        
        log.debug("datum je " + zacatek);
        log.debug(String.valueOf(zacatek.getClass()));

        if (hledaneKategorie.size() == 0) {
            return lekceService.najdiLekce(zacatek, konec);
        } else {
            return lekceService.najdiLekceDleKategorii(zacatek, konec, hledaneKategorie);
        }
    }

    @PostMapping(path = "/addOne", consumes = "application/json")
    public @ResponseBody
    void pridejJednuLekci(@RequestBody Lekce novaLekce) {
        lekceService.pridejJednuLekci(novaLekce);
    }

    @PostMapping(path = "/addMore", consumes = "application/json")
    public @ResponseBody
    void pridejVicLekci(@RequestBody List<Lekce> noveLekce) {
        log.debug("jsem v kontroleru");
        log.debug("toto jsou nové lekci, které projdou funckí pro přidání_:" + noveLekce.toString());
        lekceService.pridejVicLekci(noveLekce);
    }
}

