package com.top.lang.toplang.controllers;

import com.top.lang.toplang.entity.LanguageEntity;
import com.top.lang.toplang.entity.UserEntity;
import com.top.lang.toplang.repository.LanguageRepository;
import com.top.lang.toplang.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.security.Security;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping("/")
    public String home(Model model) {
//        LanguageEntity language = new LanguageEntity();
//        language.setCode("rs");
//        language.setName("Serbian");
//        language.setDescription("anskdjbahb");
//        languageRepository.save(language);
//        LessonEntity lesson = new LessonEntity();
//        lesson.setName("Padezhi");
//        lesson.setSlug("padezhi");
//        lesson.setLanguage(language);
//        lessonRepository.save(lesson);

        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Iterable<LanguageEntity> languages = languageRepository.findAll();
        model.addAttribute("title", "Главная страница");
        model.addAttribute("languages", languages);
        model.addAttribute("auth", user instanceof UserEntity ? true : false);
        return "home";
    }
}
