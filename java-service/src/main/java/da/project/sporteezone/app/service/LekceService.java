package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.repository.LekceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class LekceService {

    @Autowired
    private LekceRepository lekceRepository;

    public List<Lekce> zobrazVsechnyLekce() {
        return lekceRepository.findAll();
    }

    public Lekce pridejJednuLekci(Lekce novaLekce) {
        lekceRepository.saveAndFlush(novaLekce);
        return novaLekce;
    }

    public List<Lekce> pridejVicLekci(List<Lekce> noveLekce) {
        ArrayList<Lekce> ulozeneLekce = new ArrayList();
        log.info(String.valueOf(noveLekce));
        for (Lekce jednaLekce : noveLekce) {
            Lekce moznaShoda = lekceRepository.findByZacatek(jednaLekce.getZacatek());
            if (moznaShoda == null) {
                lekceRepository.saveAndFlush(jednaLekce);
                ulozeneLekce.add(jednaLekce);
            } else {
                if (!jednaLekce.lekceEquals(moznaShoda)) {
                    lekceRepository.saveAndFlush(jednaLekce);
                    ulozeneLekce.add(jednaLekce);
                } else {
                    log.debug("Lekce " + jednaLekce + " už v DB je jako " + moznaShoda);
                }
            }
        }
        return ulozeneLekce;
    }

        public List<Lekce> najdiLekce (LocalDateTime zacatek, LocalDateTime konec){
            log.debug("datum je " + zacatek);
            log.debug(String.valueOf(zacatek.getClass()));
            return lekceRepository.findAllByZacatekBetween(zacatek, konec);
        }
    }

