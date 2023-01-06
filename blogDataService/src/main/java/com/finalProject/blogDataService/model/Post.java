package com.finalProject.blogDataService.model;

import java.time.LocalDate;

public class Post {

    private Integer id;

    private String title;

    private LocalDate date;

    private String section;

    private Integer userId;

    private String description;

    private String urlImagen;


    public Post() {
    }

    public Post(String title, LocalDate date, String section, Integer userId, String description, String urlImagen) {
        setTitle(title);
        setDate(date);
        setSection(section);
        setUserId(userId);
        setDescription(description);
        setUrlImagen(urlImagen);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
