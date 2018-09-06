package com.todo.spring.models;

import com.todo.spring.models.base.ModelBase;

public class Todo extends ModelBase{

    private String title;
    private String description;
    private Boolean isActive;

    public Todo(String title, String description, Boolean isActive) {
        this.title = title;
        this.description = description;
        this.isActive = isActive;
    }

    public Todo() {
    }

    public void setStatus(Boolean status) {
        this.isActive = status;
    }

    public Boolean getStatus() {
        return isActive;
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
