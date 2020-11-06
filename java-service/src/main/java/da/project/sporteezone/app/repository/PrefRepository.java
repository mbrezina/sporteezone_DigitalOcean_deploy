package da.project.sporteezone.app.repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrefRepository extends JpaRepository<Preference, Integer> {

    //@Query("FROM Preference WHERE sub = ?1")
    List<Preference> findBySub(String sub);


}
