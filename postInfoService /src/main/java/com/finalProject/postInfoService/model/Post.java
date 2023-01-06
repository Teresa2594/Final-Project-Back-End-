package com.finalProject.postInfoService.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    private Integer id;
    private String title;
    private LocalDate date;
    private String section;

    private Integer userId;

    private String description;

    private String urlImagen;

    public Post() {
    }

    public Post(Integer id, String title, LocalDate date, String section, Integer userId, String description, String urlImagen) {
        setId(id);
        setTitle(title);
        setDate(date);
        setSection(section);
        setUserId(userId);
        setDescription(description);
        setUrlImagen(urlImagen);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section=section;
    }

    public Integer getId() {
        return id;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}