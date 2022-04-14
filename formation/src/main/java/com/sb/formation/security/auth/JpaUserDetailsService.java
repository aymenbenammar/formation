package com.sb.formation.security.auth;

import com.sb.formation.entities.Authority;
import com.sb.formation.entities.Utilisateur;
import com.sb.formation.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur applicationUser = userRepository.findByUsername(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("Username " + username + "Not Found");
        });

        return convertUserToSpringSecurityUser(applicationUser);
    }

    private UserDetails convertUserToSpringSecurityUser(Utilisateur applicationUser) {
        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(), applicationUser.getPassword(),
                applicationUser.isEnabled(), applicationUser.isAccountNonExpired(), applicationUser.isCredentialsNonExpired(), applicationUser.isAccountNonLocked(),
                convertUserAuthoritiesToSpringUserAuthority(applicationUser.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> convertUserAuthoritiesToSpringUserAuthority(Set<Authority> authorities) {
        if (authorities != null && !authorities.isEmpty()) {
            return authorities
                    .stream()
                    .map(Authority::getPermission)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
        } else
            return new HashSet<>();
    }

}
