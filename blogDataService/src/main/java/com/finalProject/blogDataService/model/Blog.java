package com.finalProject.blogDataService.model;


import java.util.List;

public class Blog {
    private List<Post> posts;
    private User user;

    public Blog() {
    }

    public Blog(List<Post> posts, User user) {
        setPosts(posts);
        setUser(user);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
