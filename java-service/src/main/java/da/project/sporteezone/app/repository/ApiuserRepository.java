package da.project.sporteezone.app.repository;

import da.project.sporteezone.app.entity.Apiuser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ApiuserRepository extends JpaRepository<Apiuser, Long>  {
    Optional<Apiuser> findByUsername(String username);

    //void save(List<ApiUser> listApiUsers);


}
