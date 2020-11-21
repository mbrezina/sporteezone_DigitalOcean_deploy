package da.project.sporteezone.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "fitness")
public class Fitness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nazev;
    private String url;
    private String ulice;
    private String mesto;
    private String psc;
    private String email;
    private Integer telefon;
    private Float lng;
    private Float lat;
    private Boolean parkoviste;
    private Boolean mhd;
    private Boolean wellness;
    private Boolean obcerstveni;
    private Boolean muzi;
    private Boolean pomucky;

    //@OneToMany(mappedBy = "lekce", fetch = FetchType.EAGER)
    //private List<Lekce> seznamLekci;

}
