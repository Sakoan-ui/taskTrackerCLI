package com.example;

import java.util.Scanner;

public class CLI {
    private Scanner scanner;

    public CLI() {
        scanner = new Scanner(System.in);
    }

    public static void hello(){
        System.out.println("~~~~~~Task Tracker~~~~~~\n" +
                "Type 'help' to display a list of commands");
    }

    public String readLine(){
        return scanner.nextLine();
    }

    public static void writeLine(String line){
        System.out.println(line);
    }
}
