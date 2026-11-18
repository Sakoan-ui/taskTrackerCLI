package com.example;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

public class Task implements Serializable {
    private final long id;
    private String text;
    private boolean isDone;
    private LocalDateTime deadline;

    public Task(long id, String text) {
        this.id = id;
        this.text = text;
        isDone = false;
    }

    public Task(long id, String text, boolean isDone, LocalDateTime deadline) {
        this.id = id;
        this.text = text;
        this.isDone = isDone;
        this.deadline = deadline;
    }

    public long getId() {
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

    public Optional<LocalDateTime> getDeadline() {
        return Optional.ofNullable(deadline);
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "#" + id +
                (isDone ? "✅" : (deadline.isAfter(LocalDateTime.now()) ? "⬜" : "❌")) +
                getDeadline().map(LocalDateTime::toString).orElse("without a deadline") +
                text;
    }
}
