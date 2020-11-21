package da.project.sporteezone.app.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@Entity
public class Zakaznik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sub;
    private String name;
    private String email;

    public Zakaznik() {
    }

    public Zakaznik(String sub, String name, String email) {
        this.sub = sub;
        this.name = name;
        this.email = email;
    }
}

