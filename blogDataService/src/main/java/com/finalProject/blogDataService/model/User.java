package com.finalProject.blogDataService.model;

public class User {
    private Integer id;

    private String name;

    private String username;

    private String email;

    private String address;

    private String location;

    private Integer age;

    private String gender;

    private String password;

    private String imagen;

    public User() {
    }

    public User(Integer id, String name, String username, String email, String address, String location, Integer age, String gender, String password, String imagen) {
        setId(id);
        setName(name);
        setUsername(username);
        setEmail(email);
        setAddress(address);
        setLocation(location);
        setAge(age);
        setGender(gender);
        setPassword(password);
        setImagen(imagen);

    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
