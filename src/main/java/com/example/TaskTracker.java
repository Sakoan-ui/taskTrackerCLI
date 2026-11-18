package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        while (!(command = cli.read().toLowerCase().trim()).equals("exit")) {
            switch (command) {
                case "help" -> {
                    CLI.writeCommand(Commands.HELP);
                }
                case "add" -> {
                    CLI.writeCommand(Commands.ENTER_TEXT);
                    memoryTaskRepository.add(cli.read());
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
                case "done" -> {
                    CLI.writeCommand(Commands.ENTER_ID);
                    while (true) {
                        try {
                            memoryTaskRepository.done(Long.parseLong(cli.read()));
                            break;
                        } catch (NumberFormatException _) {
                            CLI.writeCommand(Commands.TRY_AGAIN);
                        }
                    }
                }
                case "delete" -> {
                    CLI.writeCommand(Commands.ENTER_ID);
                    while (true) {
                        try {
                            memoryTaskRepository.delete(Long.parseLong(cli.read()));
                            break;
                        } catch (NumberFormatException _) {
                            CLI.writeCommand(Commands.TRY_AGAIN);
                        }
                    }
                }
                case "search" -> {
                    CLI.writeCommand(Commands.ENTER_TEXT);
                    memoryTaskRepository.search(cli.read()).forEach(CLI::writeTask);
                }
                case "set_deadline" -> {
                    CLI.writeCommand(Commands.ENTER_ID);
                    long id;
                    while (true) {
                        try {
                            id = Long.parseLong(cli.read());
                            break;
                        } catch (NumberFormatException _) {
                            CLI.writeCommand(Commands.TRY_AGAIN);
                        }
                    }
                    CLI.writeCommand(Commands.ENTER_DEADLINE);
                    LocalDateTime deadline;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy HH:mm");
                    while (true) {
                        try {
                            deadline= LocalDateTime.parse(cli.read(), formatter);
                            break;
                        } catch (DateTimeParseException _) {
                            CLI.writeCommand(Commands.TRY_AGAIN);
                        }
                    }
                    memoryTaskRepository.setDeadline(id, deadline);
                }
                default -> {
                    CLI.writeCommand(Commands.TRY_AGAIN);
                }
            }
        }
    }
}
