package com.example;

public enum Commands {
    HELLO("~~~~~~Task Tracker~~~~~~\n" +
            "Type 'help' to display a list of commands"),
    HELP("""
            add\tadds a task
            list\tshows all tasks
            list_active\tonly unexecuted
            list_done\tonly completed
            list_overdue\tonly overdue
            done\tmarks the task as completed
            delete\tdeletes a task
            search\ttasks that contain the word (case insensitive)
            set_deadline\t set deadline task
            help\tlist of commands
            exit\texit"""),
    ENTER_TEXT("Enter text"),
    ENTER_ID("Enter ID"),
    TRY_AGAIN("Error, try again"),
    ENTER_DEADLINE("Enter deadline in format dd.MM.yyyy HH:mm");
    private final String text;

    Commands(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
