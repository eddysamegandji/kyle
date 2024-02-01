package com.kylemanagement.config.security;

import com.kylemanagement.repository.UserRepository;
import com.kylemanagement.model.User;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User findUser =  userRepository.findUserByLogin(username);
        if (!ObjectUtils.isEmpty(findUser)) {
            Authentication authentication= new UsernamePasswordAuthenticationToken(findUser.getLogin(), findUser.getPassword(), findUser.getAuthorities()) ;
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return findUser;
        } else {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

