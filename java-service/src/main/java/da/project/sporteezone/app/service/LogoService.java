package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.repository.FitnessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Optional;

@Slf4j
@Service
public class LogoService {

    @Autowired
    FitnessRepository fitnessRepository;

    //@Override
    /* @Transactional
    public void saveLogoFile(Integer fitnessId, MultipartFile file) {

        try {
            Fitness fitness = fitnessRepository.findById(fitnessId).get();

            //Byte[] byteObjects = new Byte[file.getBytes().length];
            Blob byteObjects = new Byte[file.getBytes()];

            int i = 0;
            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            fitness.setLogo(byteObjects);
            fitnessRepository.save(fitness);

        } catch (IOException e) {
            log.error("Error occurred", e);
            e.printStackTrace();
        }
    }

     */


}
