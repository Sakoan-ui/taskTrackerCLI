package com.example;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryTaskRepository implements TaskRepository{
    private HashMap<Long, Task> memory;
    private long lastId;

    public MemoryTaskRepository() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("memory.dat"))) {
            memory = (HashMap<Long, Task>) in.readObject();
            lastId = in.readLong();
        } catch (FileNotFoundException e) {
            memory = new HashMap<>();
            lastId = 0;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateMemory(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("memory.dat"))){
            out.writeObject(memory);
            out.writeLong(lastId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String text) {
        memory.put(lastId, new Task(lastId++, text.trim()));
        updateMemory();
    }

    @Override
    public List<Task> list() {
        return new ArrayList<>(memory.values());
    }

    @Override
    public List<Task> listActive() {
        return memory.values().stream()
                .filter(t -> !t.isDone() && t.getDeadline().orElse(LocalDateTime.MAX).isAfter(LocalDateTime.now()))
                .toList();
    }

    @Override
    public List<Task> listDone() {
        return memory.values().stream()
                .filter(Task::isDone)
                .toList();
    }

    @Override
    public List<Task> listOverdue() {
        return memory.values().stream()
                .filter(t -> t.getDeadline().orElse(LocalDateTime.MAX).isBefore(LocalDateTime.now()))
                .toList();
    }

    @Override
    public void done(long id) {
        memory.get(id).setDone(true);
        updateMemory();
    }

    @Override
    public void delete(long id) {
        memory.remove(id);
        updateMemory();
    }

    @Override
    public List<Task> search(String text) {
        return memory.values().stream()
                .filter(t -> t.getText().toLowerCase().contains(text.trim().toLowerCase()))
                .toList();
    }

    public void setDeadline(long id, LocalDateTime deadLine){
        memory.get(id).setDeadline(deadLine);
        updateMemory();
    }
}
