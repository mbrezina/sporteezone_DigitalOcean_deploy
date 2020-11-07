package da.project.sporteezone.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
    private Float lon;
    private Float lat;
    private Boolean multisport;
    private Boolean activepass;
    private String platba;
    private String pohlavi;
    private Boolean mhd;

}
