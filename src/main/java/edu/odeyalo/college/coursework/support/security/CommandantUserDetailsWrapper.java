package edu.odeyalo.college.coursework.support.security;

import edu.odeyalo.college.coursework.entity.Commandant;
import edu.odeyalo.college.coursework.entity.CommandantCredentials;
import edu.odeyalo.college.coursework.support.security.IdAwareUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class CommandantUserDetailsWrapper implements IdAwareUserDetails {
    private final CommandantCredentials credentials;
    private final Commandant commandant;

    public CommandantUserDetailsWrapper(CommandantCredentials credentials) {
        this.credentials = credentials;
        this.commandant = credentials.getCommandant();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority("COMMANDANT"));
    }

    @Override
    public String getPassword() {
        return credentials.getPassword();
    }

    @Override
    public String getUsername() {
        return credentials.getUsername();
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
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getId() {
        return String.valueOf(credentials.getId());
    }

    public Commandant getCommandant() {
        return commandant;
    }
}
