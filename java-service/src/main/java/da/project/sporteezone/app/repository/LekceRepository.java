package da.project.sporteezone.app.repository;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.entity.Trener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;




public interface LekceRepository extends JpaRepository <Lekce, Integer> {

    List<Lekce> findAllByZacatekBetween(LocalDateTime zacatek, LocalDateTime konec);
    Lekce findByZacatek(LocalDateTime zacatek);
    Lekce findByKodFitko(Integer kodFitko);
}
