package da.project.sporteezone.app.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "preference")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="sub")
    private String sub;

    @Column(name="aktivita")
    private String aktivita;

}

