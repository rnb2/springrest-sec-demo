package com.rnb.springrestsecdemo.service;

import com.rnb.springrestsecdemo.model.User;
import com.rnb.springrestsecdemo.secur.UserPrincipal;
import com.rnb.springrestsecdemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User name not found: " + username);
        }

        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
