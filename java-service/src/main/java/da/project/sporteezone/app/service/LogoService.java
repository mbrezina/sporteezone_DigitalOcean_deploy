package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Lekce;
import da.project.sporteezone.app.entity.Logo;
import da.project.sporteezone.app.repository.FitnessRepository;
import da.project.sporteezone.app.repository.LogoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Optional;

@Slf4j
@Service
public class LogoService {

    @Autowired
    LogoRepository logoRepository;

    public void saveFitnessLogo(int fitnessId, MultipartFile logoFile) throws IOException {
        Logo img = new Logo(logoFile.getOriginalFilename(), logoFile.getContentType(), fitnessId, logoFile.getBytes());
        logoRepository.save(img);
    }

    public void viewFitnessLogo(int fitnessId, HttpServletResponse response) throws IOException {
        Logo retrievedImage = logoRepository.findByFitnessId(fitnessId);
        response.setContentType("image/png");
        IOUtils.copy(new ByteArrayInputStream(retrievedImage.getPicByte()), response.getOutputStream());
        response.flushBuffer();
    }
    
}
