package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Preference;
import da.project.sporteezone.app.repository.PrefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrefService {

    @Autowired
    private PrefRepository prefRepository;

    public List<String> getSeznamPreferenci(String sub) {
        List<Preference> seznamUzivatele = prefRepository.findBySub(sub);
        List<String> preferenceUzivatele = new ArrayList<>();
        for (Preference record : seznamUzivatele) {
            preferenceUzivatele.add(record.getAktivita());
        }
        return preferenceUzivatele;
    }

}
