package com.example;

import java.time.LocalDateTime;

public class Task {
    private final int id;
    private String text;
    private boolean isDone;
    private LocalDateTime deadline;

    public Task(int id, String text) {
        this.id = id;
        this.text = text;
        isDone = false;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
