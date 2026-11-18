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

    public static void help(){
        System.out.println("add <текст>\tдобавляет задачу\n" +
                "list\tпоказывает все задачи\n" +
                "list active / list done\tтолько невыполненные / только выполненные\n" +
                "done <id>\tотмечает задачу выполненной\n" +
                "delete <id>\tудаляет задачу\n" +
                "search <слово>\tзадачи, в тексте которых есть слово (без учёта регистра)\n" +
                "help\tсписок команд\n" +
                "exit\tвыход");
    }

    public String readLine(){
        return scanner.nextLine();
    }

    public static void writeLine(String line){
        System.out.println(line);
    }
}
