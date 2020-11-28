package da.project.sporteezone.app.entity;

import da.project.sporteezone.app.entity.Fitness;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "logo")
public class Logo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Lob
    private byte[] data;


    //https://www.callicoder.com/spring-boot-file-upload-download-jpa-hibernate-mysql-database-example/


}

