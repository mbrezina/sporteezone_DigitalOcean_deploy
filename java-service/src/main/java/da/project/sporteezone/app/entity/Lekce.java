package da.project.sporteezone.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "lekce")
public class Lekce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nazev;
    private String url;

    private LocalDateTime zacatek;
    private LocalDateTime konec;

    private Integer kapacita;
    private Boolean nutnostRezervace;
    private Integer cena;

    @Column(name="kod_fitko")
    private Integer kodFitko;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="kod_trener")
    @JsonIgnore
    private Trener trener;

}

