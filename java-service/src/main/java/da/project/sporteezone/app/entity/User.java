package da.project.sporteezone.app.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sub;
    private String name;
    private String email;

    public User() {
    }

    public User(String sub, String name, String email) {
        this.sub = sub;
        this.name = name;
        this.email = email;
    }
}


    /*
    public List<String> getRolesList() {

        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public User() {
    }

    public User(String username, String password, Integer active, String roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }


     */
