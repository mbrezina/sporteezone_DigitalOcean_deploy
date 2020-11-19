package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Zakaznik;
import da.project.sporteezone.app.repository.ZakaznikRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ZakaznikService {

    @Autowired
    private ZakaznikRepository zakaznikRepository;

    public List<Zakaznik> zobrazVsechnyUzivatele() {
        return zakaznikRepository.findAll();
    }

    public Zakaznik najdiPodleSub(String sub) {
        return zakaznikRepository.findBySub(sub);
    }

    public Zakaznik ulozUzivatele(Zakaznik zakaznik) {
        zakaznikRepository.saveAndFlush(zakaznik);
        return zakaznik;
    }
}
