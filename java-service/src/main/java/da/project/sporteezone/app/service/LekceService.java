package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.entity.Trener;
import da.project.sporteezone.app.repository.LekceRepository;
import lombok.extern.slf4j.Slf4j;
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

    public Lekce pridejJednuLekci(Lekce novaLekce) {
        lekceRepository.saveAndFlush(novaLekce);
        return novaLekce;
    }

    public String pridejVicLekci(List<Lekce> noveLekce) {
        log.debug(String.valueOf(noveLekce));
        Integer ulozeneLekce = 0;
        Integer updatovaneLekce = 0;

        for (Lekce novaLekce : noveLekce) {
            Lekce shodnaLekce = lekceRepository.findByZacatekAndNazevAndKodFitko(novaLekce.getZacatek(), novaLekce.getNazev(), novaLekce.getKodFitko());
            if (shodnaLekce == null) {
                lekceRepository.saveAndFlush(novaLekce);
                ulozeneLekce++;
            } else {

                Boolean stejny_trener = shodnaLekce.getJmenoTrener().equals(novaLekce.getJmenoTrener());
                Boolean stejna_obsazenost = shodnaLekce.getObsazenost().equals(novaLekce.getObsazenost());

                if (!stejna_obsazenost || !stejny_trener) {
                    shodnaLekce.setObsazenost(novaLekce.getObsazenost());
                    shodnaLekce.setJmenoTrener(novaLekce.getJmenoTrener());
                    lekceRepository.saveAndFlush(shodnaLekce);
                    updatovaneLekce++;
                }
            }
        }
        return "Počet uložených lekcí: " + ulozeneLekce + ", počet updatovaných lekcí: " + updatovaneLekce;
    }


    public List<Lekce> najdiLekcePodleTrenera(String jmenoTrenera) {
        return lekceRepository.findByJmenoTrener(jmenoTrenera);
    }


    public List<Lekce> najdiLekce(LocalDateTime zacatek, LocalDateTime konec) {
        log.debug("datum je " + zacatek);
        log.debug(String.valueOf(zacatek.getClass()));
        return lekceRepository.findAllByZacatekBetween(zacatek, konec);
    }
}

