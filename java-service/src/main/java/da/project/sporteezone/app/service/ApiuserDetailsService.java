package da.project.sporteezone.app.service;

import da.project.sporteezone.app.entity.Apiuser;
import da.project.sporteezone.app.entity.ApiuserDetails;
import da.project.sporteezone.app.repository.ApiuserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
//        List<Apiuser> seznamVsech = apiuserRepository.findAll();
//        Iterator iterator = seznamVsech.iterator();
//        while(iterator.hasNext()) {
//            log.info(String.valueOf(iterator.next()));
//        }

        Apiuser apiuser = apiuserRepository.findApiuserByUsername(username);

        if (apiuser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new ApiuserDetails(apiuser);
    }
}


