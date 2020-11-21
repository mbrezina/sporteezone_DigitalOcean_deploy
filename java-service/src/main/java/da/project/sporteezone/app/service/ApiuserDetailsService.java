package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Apiuser;
import da.project.sporteezone.app.entity.ApiuserDetails;
import da.project.sporteezone.app.repository.ApiuserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class ApiuserDetailsService implements UserDetailsService {

    @Autowired
    private ApiuserRepository apiuserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Apiuser> seznamVsech = apiuserRepository.findAll();
        Iterator iterator = seznamVsech.iterator();
        while(iterator.hasNext()) {
            log.info(String.valueOf(iterator.next()));
        }

        Apiuser apiuser = apiuserRepository.findApiuserByUsername(username);
        log.info("vytahuji uživatele");

        if (apiuser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new ApiuserDetails(apiuser);
    }


        /*//Optional<Apiuser> apiuser = apiuserRepository.findByUsername(userName);
        Apiuser apiuser = apiuserRepository.findByUsername(userName);
        log.info("vytahuji uživatele");
        apiuser.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return apiuser.map(ApiuserDetails::new).get();

           /*Here we are using dummy data, you need to load user data from
     database or other third party application
        Apiuser apiuser = apiuserRepository.findByUsername(userName);

        User.UserBuilder builder = null;
        if (apiuser != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(userName);
            builder.password(new BCryptPasswordEncoder().encode(apiuser.getPassword()));
            builder.roles(apiuser.getRoles());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

         */
}


