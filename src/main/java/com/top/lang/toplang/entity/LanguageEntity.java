package com.top.lang.toplang.entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "lang")
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String code;

    @OneToMany(mappedBy = "language")
    List<LessonEntity> lessons;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LessonEntity> getLessons() {
        return lessons;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
