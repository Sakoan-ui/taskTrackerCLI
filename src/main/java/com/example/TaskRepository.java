package com.example;

import java.util.List;

public interface TaskRepository {
    void add(String text);
    List<Task> list();
    List<Task> listActive();
    List<Task> listDone();
    List<Task> listOverdue();
    void done(long id);
    void delete(long id);
    List<Task> search(String text);
}
