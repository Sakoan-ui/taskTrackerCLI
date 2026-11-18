package com.example;

public class TaskTracker {
    private CLI cli;
    private TaskRepository memoryTaskRepository;

    public TaskTracker() {
        this.cli = new CLI();
        this.memoryTaskRepository = new MemoryTaskRepository();
    }
    public void run(){
        CLI.hello();
        CLI.help();
        String cur;
        while (!(cur = cli.readLine()).equals("exit")){
            switch (cur){
                case "add" -> {
                    memoryTaskRepository.add(cli.readLine());
                }
                case "list" -> {
                    memoryTaskRepository.list();
                }
            }
        }
    }
}
