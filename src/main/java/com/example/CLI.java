package com.example;

import java.util.Scanner;

public class CLI {
    private Scanner scanner;

    public CLI() {
        scanner = new Scanner(System.in);
    }

    public String readCommand(){
        return scanner.nextLine();
    }

    public static void writeTask(Task task){
        System.out.println(task);
    }

    public static void writeCommand(Commands command){
        System.out.println(command.getText());
    }
}
