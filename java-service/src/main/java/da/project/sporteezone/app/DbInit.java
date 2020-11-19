package da.project.sporteezone.app;

//import da.project.sporteezone.app.entity.ApiUser;
//import da.project.sporteezone.app.repository.ApiUserRepository;

//import jdk.internal.org.jline.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/*
@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private ApiUserRepository apiUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Delete all:
        apiUserRepository.deleteAll();

        //Create users:
        ApiUser martina = new ApiUser("martina", passwordEncoder.encode("mar123"), 1, "USER");
        ApiUser admin = new ApiUser("admin", passwordEncoder.encode("admin"), 1, "ADMIN");

        List<ApiUser> users = Arrays.asList(martina, admin);
        apiUserRepository.saveAll(users);

    }

}


/*
@Component

public class DbInit implements CommandLineRunner {

    @Autowired
    private ApiUserRepository apiUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Delete all:
        apiUserRepository.deleteAll();

        //Create users:
        ApiUser martina = new ApiUser("martina", passwordEncoder.encode("mar123"), 1, "USER");
        ApiUser admin = new ApiUser("admin", passwordEncoder.encode("admin"), 1, "ADMIN");
        System.out.println("jsem tady");

        apiUserRepository.saveAndFlush(martina);
        apiUserRepository.saveAndFlush(admin);


        //List<ApiUser> apiUsers = Arrays.asList(martina, admin);
        //apiUserRepository.saveAll(apiUsers);

    }
}*/
