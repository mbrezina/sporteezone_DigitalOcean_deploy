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

    @Column(name = "fitness_id")
    private Integer fitnessId;

    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Column(name = "pic_byte", length = 1000)
    private byte[] picByte;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFitnessId(Integer fitnessId) {
        this.fitnessId = fitnessId;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public Integer getFitnessId() {
        return fitnessId;
    }

    public byte[] getPicByte() {
        return picByte;
    }


    public Logo(String fileName, String fileType, Integer fitnessId, byte[] picByte) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fitnessId = fitnessId;
        this.picByte = picByte;
    }

    public Logo() {
    }

//https://www.callicoder.com/spring-boot-file-upload-download-jpa-hibernate-mysql-database-example/


}

