package com.top.lang.toplang.controllers;

import com.top.lang.toplang.entity.LanguageEntity;
import com.top.lang.toplang.entity.LessonEntity;
import com.top.lang.toplang.repository.LanguageRepository;
import com.top.lang.toplang.repository.LessonRepository;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class LanguageController {
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    LessonRepository lessonRepository;

    @GetMapping("/lang/{code}")
    public String getLanguageByCode(@PathVariable String code, Model model) {
        LanguageEntity language = languageRepository.findByCode(code);
        model.addAttribute("title", language.getName());
        model.addAttribute("language", language);
        return "language";
    }

    @GetMapping("/lesson/{slug}")
    public String getLessonBySlug(@PathVariable String slug, Model model) throws IOException {
        LessonEntity lesson = lessonRepository.findBySlug(slug);
        ClassPathResource classPathResource = new ClassPathResource("lessons/" + slug + ".txt");
        byte[] data = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
        String content = new String(data, StandardCharsets.UTF_8);
        String html = convertMDToHTML(content);
        model.addAttribute("title", lesson.getName());
        model.addAttribute("content", html);
        return "lesson";
    }

    private String convertMDToHTML(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
        return htmlRenderer.render(document);
    }
}
