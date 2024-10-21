package com.top.lang.toplang.service;

import com.top.lang.toplang.entity.UserEntity;
import com.top.lang.toplang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService, UserDetailsService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(UserEntity user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public List<Object> isUserPresent(UserEntity user) {
        boolean userExists = false;
        String message = null;
        Optional<UserEntity> existingUserEmail = userRepository.findByEmail(user.getEmail());
        if(existingUserEmail.isPresent()){
            userExists = true;
            message = "Email Already Present!";
        }
        System.out.println("existingUserEmail.isPresent() - " + existingUserEmail.isPresent());
        return Arrays.asList(userExists, message);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                String.format("USER_NOT_FOUND", email)
        ));
    }
}
