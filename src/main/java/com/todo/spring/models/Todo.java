package com.todo.spring.models;

import com.todo.spring.models.base.ModelBase;

public class Todo extends ModelBase{

    private String title;
    private String description;
    private Boolean status;

    public Todo(String title, String description, Boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Todo() {
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
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
