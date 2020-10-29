package da.project.sporteezone.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
//import jdk.internal.org.jline.utils.Log;
//import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
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

    @Column(name = "kod_fitko")
    private Integer kodFitko;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kod_trener")
    @JsonIgnore
    private Trener trener;


    public boolean lekceEquals(Lekce porovnavanaLekce) {
        log.debug("jsem ve fci lekce Equals");
        if (this == porovnavanaLekce) return true;//if both of them points the same address in memory
        log.debug(String.valueOf(this.zacatek));
        log.debug(String.valueOf(porovnavanaLekce.zacatek));

        Boolean stejny_zacatek = zacatek.compareTo(porovnavanaLekce.zacatek) == 0;
        Boolean stejne_fitko = this.kodFitko.equals(porovnavanaLekce.kodFitko);
        Boolean stejny_nazev = this.nazev.equals(porovnavanaLekce.nazev);
        return (stejne_fitko && stejny_zacatek && stejny_nazev);
    }
}


