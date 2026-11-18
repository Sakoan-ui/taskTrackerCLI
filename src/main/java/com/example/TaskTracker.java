package com.example;

public class TaskTracker {
    private CLI cli;
    private TaskRepository memoryTaskRepository;

    public TaskTracker() {
        this.cli = new CLI();
        this.memoryTaskRepository = new MemoryTaskRepository();
    }

    public void run() {
        CLI.writeCommand(Commands.HELLO);
        String command;
        while (!(command = cli.readCommand().toLowerCase().trim()).equals("exit")) {
            switch (command) {
                case "add" -> {
                    CLI.writeCommand(Commands.ENTER_TASK);
                    memoryTaskRepository.add(cli.readCommand());
                }
                case "list" -> {
                    memoryTaskRepository.list().forEach(CLI::writeTask);
                }
                case "list_active" -> {
                    memoryTaskRepository.listActive().forEach(CLI::writeTask);
                }
                case "list_done" -> {
                    memoryTaskRepository.listDone().forEach(CLI::writeTask);
                }
                case "list_overdue" -> {
                    memoryTaskRepository.listOverdue().forEach(CLI::writeTask);
                }
            }
        }
    }
}
