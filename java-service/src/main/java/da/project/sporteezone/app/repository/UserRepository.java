package da.project.sporteezone.app.repository;


import com.nimbusds.openid.connect.sdk.claims.UserInfo;
import da.project.sporteezone.app.entity.GoogleUserInfo;
import da.project.sporteezone.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>  {
    //User findByUsername(String username);

    Optional<User> findByEmail(String email);


}
