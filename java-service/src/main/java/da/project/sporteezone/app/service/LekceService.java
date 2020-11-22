package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.entity.Trener;
import da.project.sporteezone.app.repository.LekceRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LekceService {

    @Autowired
    private LekceRepository lekceRepository;

    public List<Lekce> zobrazVsechnyLekce() {
        return lekceRepository.findAll();
    }

    public void pridejJednuLekci(Lekce novaLekce) {
        zpracujLekci(novaLekce);
        log.info("Počet nově nahraných lekcí: 1");
    }

    public void pridejVicLekci(List<Lekce> noveLekce) {
        log.debug(String.valueOf(noveLekce));
        Integer pocetNovychLekci = 0;
        for (Lekce jednaNovaLekce : noveLekce) {
            pocetNovychLekci += zpracujLekci(jednaNovaLekce);
        }
        log.info("Počet nově nahraných lekcí" + pocetNovychLekci);
    }

    public Integer zpracujLekci(Lekce novaLekce) {
        Lekce shodnaLekce = lekceRepository.findByZacatekAndNazevAndKodFitko(novaLekce.getZacatek(), novaLekce.getNazev(), novaLekce.getKodFitko());
        if (shodnaLekce == null) {
            lekceRepository.saveAndFlush(novaLekce);
            return 1;
        } else {
            Boolean stejna_obsazenost = shodnaLekce.getObsazenost().equals(novaLekce.getObsazenost());
            if (!stejna_obsazenost) {
                shodnaLekce.setObsazenost(novaLekce.getObsazenost());
                lekceRepository.saveAndFlush(shodnaLekce);
            }
            return 0;
        }
    }

    public List<Lekce> najdiLekce(LocalDateTime zacatek, LocalDateTime konec) {
        log.debug("datum je " + zacatek);
        log.debug(String.valueOf(zacatek.getClass()));
        return lekceRepository.findAllByZacatekBetween(zacatek, konec);
    }
}

