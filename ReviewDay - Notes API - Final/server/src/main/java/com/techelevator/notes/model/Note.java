package com.techelevator.notes.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Note {
    private int id;
    private int userId;
    private String message;
    private LocalDate createdDate;
    private LocalDate todoDate;

    public Note(int id, int userId, String message, LocalDate createdDate, LocalDate todoDate) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.createdDate = createdDate;
        this.todoDate = todoDate;
    }
    public Note(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
    @JsonProperty("user_id")
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @JsonProperty("created_date")
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("todo_date")
    public LocalDate getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(LocalDate todoDate) {
        this.todoDate = todoDate;
    }
}