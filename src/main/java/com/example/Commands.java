package com.example;

public enum Commands {
    HELLO("~~~~~~Task Tracker~~~~~~\n" +
            "Type 'help' to display a list of commands"),
    HELP("add\tadds a task\n" +
            "list\tshows all tasks\n" +
            "list_active\tonly unexecuted\n" +
            "list_done\tonly completed\n" +
            "list_overdue\tonly overdue\n" +
            "done\tmarks the task as completed\n" +
            "delete\tdeletes a task\n" +
            "search\ttasks that contain the word (case insensitive)\n" +
            "help\tlist of commands\n" +
            "exit\texit"),
    ENTER_TASK("Enter text task"),
    ENTER_ID("Enter ID");
    private final String text;

    Commands(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
