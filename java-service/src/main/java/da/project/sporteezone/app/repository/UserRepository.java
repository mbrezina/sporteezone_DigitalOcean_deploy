package da.project.sporteezone.app.repository;


import da.project.sporteezone.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long>  {
    User findByUsername(String username);

}
