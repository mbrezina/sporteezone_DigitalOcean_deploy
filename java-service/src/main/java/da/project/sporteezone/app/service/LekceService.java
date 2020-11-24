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
import java.util.*;

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
        log.info("Počet nově nahraných lekcí " + pocetNovychLekci);
    }

    public Integer zpracujLekci(Lekce novaLekce) {
        Lekce shodnaLekce = lekceRepository.findByZacatekAndNazevAndKodFitko(novaLekce.getZacatek(), novaLekce.getNazev(), novaLekce.getKodFitko());
        if (shodnaLekce == null) {
            priradKategorie(novaLekce);
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

    public List<Lekce> najdiLekceDleKategorii(LocalDateTime zacatek, LocalDateTime konec, List<String> seznamPrani) {
        List<Lekce> vsechnyPodleCasu = lekceRepository.findAllByZacatekBetween(zacatek, konec);
        List<Lekce> vysledek = new ArrayList<>();
        for (Lekce lekce : vsechnyPodleCasu) {
            if (seznamPrani.contains(lekce.getKategorie())) {
                vysledek.add(lekce);
            }
        }
        return vysledek;
    }


    public void priradKategorie(Lekce lekce) {
        String nazevLekce = lekce.getNazev().toLowerCase();

        List<String> joga = Arrays.asList("joga", "jóga", "ioga", "ióga", "yoga", "yóga");
        List<String> posilovani = Arrays.asList("core", "břicho", "bricho", "zadek", "záda", "nohy", "hýždě", "hyzde", "zadeček", "zadecek", "posilovací", "body", "h.i.i.t.", "kruhový", "funkční");
        List<String> dance = Arrays.asList("dance", "tanec", "pole");
        List<String> deti = Arrays.asList("miminek", "kojenců", "kojenecké", "kids", "junior", "dětská");
        List<String> zumba = Arrays.asList("zumba");
        List<String> pilates = Arrays.asList("pilates");
        List<String> bosu = Arrays.asList("bosu");
        List<String> tabata = Arrays.asList("tabata");
        List<String> aerobic = Arrays.asList("aerobic", "aerobik", "step");
        List<String> box = Arrays.asList("box", "kickbox");

        if (joga.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("joga");
        } else if (posilovani.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("posilovani");
        } else if (dance.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("dance");
        } else if (deti.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("děti");
        } else if (zumba.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("zumba");
        } else if (pilates.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("pilates");
        } else if (bosu.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("bosu");
        } else if (tabata.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("tabata");
        } else if (aerobic.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("aerobic");
        } else if (box.stream().anyMatch(nazevLekce::contains)) {
            lekce.setKategorie("box");
        } else {
            lekce.setKategorie("ostatní");
        }
    }
}




