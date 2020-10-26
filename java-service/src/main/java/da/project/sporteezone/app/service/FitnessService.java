package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Trener;
import da.project.sporteezone.app.repository.FitnessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FitnessService {

    @Autowired
    private FitnessRepository fitnessRepository;

    public List<Fitness> zobrazVsechnyFitness() {
        return fitnessRepository.findAll();
    }

    public Fitness pridejJednoFitko(Fitness noveFitness) {
        fitnessRepository.saveAndFlush(noveFitness);
        return noveFitness;
    }

    public List<Fitness> pridejVicFitek(List<Fitness> novaFitka) {
        fitnessRepository.saveAll(novaFitka);
        return novaFitka;
    }

    public Optional<Fitness> najdiFitko(Integer id) {
        return fitnessRepository.findById(id);
    }


}

