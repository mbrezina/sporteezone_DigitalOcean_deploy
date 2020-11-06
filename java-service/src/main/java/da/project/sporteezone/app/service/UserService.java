package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.User;
import da.project.sporteezone.app.repository.FitnessRepository;
import da.project.sporteezone.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> zobrazVsechnyUzivatele() {
        return userRepository.findAll();
    }

    public User najdiPodleSub(String sub) {
        return  userRepository.findBySub(sub);
    }

    public User ulozUzivatele(User user) {
        userRepository.saveAndFlush(user);
        return user;
    }
}
