package da.project.sporteezone.app.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ApiuserDetails implements UserDetails {   //transformuje uživatele z databáze do objektu UserDetails
    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public ApiuserDetails(Apiuser apiUser) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.authorities = Arrays.stream(apiUser.getRoles()
            .split(",")).map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
