package da.project.sporteezone.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "trener")
public class Trener {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="trener_jmeno")
    private String trenerJmeno;

    @Column(name="kod_fitko")
    private Integer kodFitko;

    //@OneToMany(mappedBy = "trener", fetch = FetchType.EAGER)
    //private List<Lekce> seznamLekci;

}

