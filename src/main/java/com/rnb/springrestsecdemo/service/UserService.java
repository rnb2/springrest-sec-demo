package com.rnb.springrestsecdemo.service;

import com.rnb.springrestsecdemo.model.User;
import com.rnb.springrestsecdemo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        User userToAdd = new User();
        String encode = encoder.encode(user.getPassword());
        userToAdd.setPassword(encode);
        userToAdd.setUsername(user.getUsername());

        return userRepository.save(userToAdd);
    }
}
