package da.project.sporteezone.app.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@Table(name="apiuser")
public class Apiuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    private Integer active;
    private String roles;

    public Apiuser(String username, String password, Integer active, String roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public Apiuser() {
    }
}
