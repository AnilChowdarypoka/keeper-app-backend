
package com.keeper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Keeper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String userEmail; // New field for user email

    public Keeper() {
        // Default constructor
    }

    public Keeper(Long id, String title, String content, String userEmail) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userEmail = userEmail;
    }

    // Getters and Setters for id, title, content, and userEmail
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // toString() method for debugging or logging purposes
    @Override
    public String toString() {
        return "Keeper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}

