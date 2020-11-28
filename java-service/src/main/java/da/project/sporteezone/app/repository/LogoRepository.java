package da.project.sporteezone.app.repository;

import da.project.sporteezone.app.entity.Logo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LogoRepository extends JpaRepository<Logo, Integer> {

    //@Query("FROM Logo WHERE nazev = ?1")
    Optional<Logo> findById(Integer id);


}



