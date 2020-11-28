package da.project.sporteezone.app.controller;

import da.project.sporteezone.app.entity.Fitness;
//import da.project.sporteezone.app.entity.FitnessInclLogo;
import da.project.sporteezone.app.repository.FitnessRepository;
import da.project.sporteezone.app.service.FitnessService;
import da.project.sporteezone.app.service.LogoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/logo")
public class LogoController {

    //@Autowired
    //private FitnessService fitnessService;

    @Autowired
    private LogoService logoService;

    @Autowired
    private FitnessRepository fitnessRepository;

    @PostMapping(path = "/add/{id}/image")
    public String handleLogoPost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {
        saveLogoFile(Integer.valueOf(id), file);
        return "redirect:/fitness/" + id + "/show";
    }

    @GetMapping(value = "/{fitnessId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void fromDatabaseAsHttpServResp(@PathVariable("fitnessId") Integer id, HttpServletResponse response)
        throws SQLException, IOException {
        Optional<Fitness> fitness = fitnessRepository.findById(id);
        if (fitness.isPresent()) {
            Blob image = fitness.get().getLogo();
            //bytes[] image = fitness.get().getLogo();
            StreamUtils.copy(image.getBinaryStream(), response.getOutputStream());
        }
    }

    @Transactional
    public void saveLogoFile(Integer fitnessId, MultipartFile file) {
        try {
            Fitness fitness = fitnessRepository.findById(fitnessId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];
            //Blob byteObjects = new Byte[file.getBytes()];
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



//    @GetMapping(path = "")
//    public @ResponseBody
//    List<Fitness> getAllFitness() {
//        return fitnessService.zobrazVsechnyFitness();
//    }

    //
//    @GetMapping(path = "/{id}")
//    public @ResponseBody
//    Optional<Fitness> getJednoFitko(@PathVariable Integer id) {
//        return fitnessService.najdiFitko(id);
//    }
//
//    @PostMapping(path = "/addOne", consumes = "application/json")
//    public @ResponseBody
//    Fitness pridejJednoFitko(@RequestBody Fitness noveFitness) {
//        fitnessService.pridejJednoFitko(noveFitness);
//        return noveFitness;
//    }
//

}


