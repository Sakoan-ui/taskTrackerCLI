package com.example;

import java.util.Scanner;

public class CLI {
    private final Scanner scanner;

    public CLI() {
        scanner = new Scanner(System.in);
    }

    public String read(){
        return scanner.nextLine();
    }

    public static void writeTask(Task task){
        System.out.println(task);
    }

    public static void writeCommand(Commands command){
        System.out.println(command.getText());
    }
}
