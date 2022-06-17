package com.example.firebasenotepad;

public class notemodel {
    private String title;
    private String description;

    public notemodel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public notemodel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
