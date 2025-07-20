package com.example.portfolio.Model;

import jakarta.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String techStack;
    private String githubLink;
    private String liveDemoLink;
    private String imageUrl;

    // ✅ Constructors
    public Project() {
    }

    public Project(String title, String description, String techStack, String githubLink, String liveDemoLink, String imageUrl) {
        this.title = title;
        this.description = description;
        this.techStack = techStack;
        this.githubLink = githubLink;
        this.liveDemoLink = liveDemoLink;
        this.imageUrl = imageUrl;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTechStack() { return techStack; }
    public void setTechStack(String techStack) { this.techStack = techStack; }

    public String getGithubLink() { return githubLink; }
    public void setGithubLink(String githubLink) { this.githubLink = githubLink; }

    public String getLiveDemoLink() { return liveDemoLink; }
    public void setLiveDemoLink(String liveDemoLink) { this.liveDemoLink = liveDemoLink; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
