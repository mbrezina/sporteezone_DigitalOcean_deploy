package da.project.sporteezone.app.repository;

import da.project.sporteezone.app.entity.Fitness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FitnessRepository extends JpaRepository<Fitness, Integer> {

    @Query("FROM Fitness WHERE nazev = ?1")
    List<Fitness> findByNazev(String nazev);




}
