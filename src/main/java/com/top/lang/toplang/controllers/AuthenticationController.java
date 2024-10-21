package com.top.lang.toplang.controllers;

import com.top.lang.toplang.entity.Role;
import com.top.lang.toplang.entity.UserEntity;
import com.top.lang.toplang.repository.UserRepository;
import com.top.lang.toplang.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthenticationController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = {"/login" }, method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title", "Login");
        return "login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("title", "Register");
        model.addAttribute("userEntity", new UserEntity());
        return "register";
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).get();
        model.addAttribute("title", "Profile");
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public String registerUser(Model model, @Valid UserEntity userEntity, BindingResult bindingResult){
        userEntity.setRole(Role.USER);
        if(bindingResult.hasErrors()){
            model.addAttribute("successMessage", "User registered successfully!");
            model.addAttribute("bindingResult", bindingResult);
            return "register";
        }
        List<Object> userPresentObj = userService.isUserPresent(userEntity);
        if((Boolean) userPresentObj.get(0)){
            model.addAttribute("successMessage", userPresentObj.get(1));
            return "register";
        }

        userService.save(userEntity);
        model.addAttribute("successMessage", "User registered successfully!");

        return "login";
    }
}
