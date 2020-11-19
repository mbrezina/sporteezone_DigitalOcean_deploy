package da.project.sporteezone.app.service;

//import da.project.sporteezone.app.UserPrincipal;
import da.project.sporteezone.app.entity.Apiuser;
//import da.project.sporteezone.app.entity.User;
import da.project.sporteezone.app.entity.ApiuserDetails;
import da.project.sporteezone.app.entity.Apiuser;
import da.project.sporteezone.app.entity.ApiuserDetails;
import da.project.sporteezone.app.repository.ApiuserRepository;
//import da.project.sporteezone.app.repository.UserRepository;
import da.project.sporteezone.app.repository.ApiuserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
public class ApiuserDetailsService implements UserDetailsService {

    @Autowired
    private ApiuserRepository apiuserRepository;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Apiuser> apiuser = apiuserRepository.findByUsername(userName);
        log.info("vytahuji uživatele");
        apiuser.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return apiuser.map(ApiuserDetails::new).get();
        
    }
}

