package da.project.sporteezone.app.repository;


import com.nimbusds.openid.connect.sdk.claims.UserInfo;
//import da.project.sporteezone.app.entity.GoogleUserInfo;
//import da.project.sporteezone.app.entity.User;
import da.project.sporteezone.app.entity.Zakaznik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ZakaznikRepository extends JpaRepository<Zakaznik, Long>  {
    //User findByUsername(String username);

    Optional<Zakaznik> findByEmail(String email);

    Zakaznik findBySub(String sub);

}
