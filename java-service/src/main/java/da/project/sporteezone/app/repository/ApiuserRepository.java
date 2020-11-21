package da.project.sporteezone.app.repository;

import da.project.sporteezone.app.entity.Apiuser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApiuserRepository extends JpaRepository<Apiuser, Integer>  {
    Apiuser findApiuserByUsername(String username);

}
