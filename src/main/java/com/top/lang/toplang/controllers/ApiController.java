package com.top.lang.toplang.controllers;

import com.top.lang.toplang.entity.Role;
import com.top.lang.toplang.entity.UserEntity;
import com.top.lang.toplang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userRepository.findAll(); // Получаем всех пользователей
        return new ResponseEntity<>(users, HttpStatus.OK);  // Возвращаем список с HTTP статусом OK
    }

    @GetMapping("/api/user/{id}")
    public String getUser(@PathVariable int id) {
        return userRepository.findById(Long.valueOf(id)).orElseThrow(() -> new UsernameNotFoundException(
                String.format("USER_NOT_FOUND", String.valueOf(id))
        )).getUsername();
    }

    @PostMapping("/api/user")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity user) {
        if (user.getRole() == null) {
            user.setRole(Role.USER); // Присваиваем роль по умолчанию, если она не указана
        }
        UserEntity savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable int id, @Valid @RequestBody UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findById(Long.valueOf(id));
        if (existingUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setId(existingUser.get().getId());  // Set existing ID to avoid creating new user
        UserEntity updatedUser = userRepository.save(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userRepository.deleteById((long) id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
