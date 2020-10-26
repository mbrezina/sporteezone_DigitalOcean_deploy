package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Trener;
import da.project.sporteezone.app.repository.TrenerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
public class TrenerService {

    @Autowired
    TrenerRepository trenerRepository;

    public Optional<Trener> najdiTrenera(Integer id) {
        return trenerRepository.findById(id);
    }


}
