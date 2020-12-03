package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Logo;
import da.project.sporteezone.app.repository.FitnessRepository;
import da.project.sporteezone.app.repository.LogoRepository;
import da.project.sporteezone.app.service.LogoService;
import lombok.extern.slf4j.Slf4j;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.cache.ICacheManager;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Slf4j
@RestController
@CrossOrigin(origins = "http://sporteezone.na-webu.info", maxAge = 3600)
@RequestMapping(path = "/api/v1/logo")
public class LogoController {

    @Autowired
    private LogoRepository logoRepository;

    @Autowired
    private LogoService logoService;

    @PostMapping("/add/{fitnessId}/image")
    public String uploadImage(@PathVariable Integer fitnessId, @RequestParam("imageFile") MultipartFile logoFile) throws IOException {
        logoService.saveFitnessLogo(fitnessId, logoFile);
        return "Logo saved";
    }

    @GetMapping(path = {"/get/{fitnessId}"})
    public void getImage(@PathVariable("fitnessId") int fitnessId, HttpServletResponse response) throws IOException {
        logoService.viewFitnessLogo(fitnessId, response);
    }
}

