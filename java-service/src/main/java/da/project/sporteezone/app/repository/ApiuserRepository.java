package da.project.sporteezone.app.repository;

import da.project.sporteezone.app.entity.Apiuser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ApiuserRepository extends JpaRepository<Apiuser, Integer>  {
    //Apiuser findByUsername(String username);
    
    Apiuser findApiuserByUsername(String username);
    List<Apiuser> findAll();

    
    //Apiuser findByUsername(String username);
    //void save(List<ApiUser> listApiUsers);


}
