package da.project.sporteezone.app.entity;

import da.project.sporteezone.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Delete all:
        userRepository.deleteAll();

        //Create users:
        User martina = new User("martina", passwordEncoder.encode("mar123"), 1, "USER");
        User admin = new User("admin", passwordEncoder.encode("admin"), 1, "ADMIN");

        List<User> users = Arrays.asList(martina, admin);
        userRepository.saveAll(users);

    }

}
