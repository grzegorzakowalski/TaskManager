package pl.coderslab;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class Menu {

    public static void printOptions(){
        System.out.println(ConsoleColors.BLUE +"Please select an option:" + ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("exit");
    }

    public static String getTaskFromUser(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Please add task description");
        stringBuilder.append(scanner.nextLine()).append("\t");
        System.out.println("Please add task due date");
        stringBuilder.append(scanner.nextLine()).append("\t");
        System.out.println("Is your task important: true/false");
        stringBuilder.append(scanner.nextLine()).append("\t");
        return stringBuilder.toString();
    }

    public static int getTaskNumberFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select task number to remove");
        String taskNumber = scanner.nextLine();
        if(NumberUtils.isParsable(taskNumber)){
            return Integer.parseInt(taskNumber);
        }
        return -1;
    }

    public static void badInput(){
        System.out.println("Illegal input");
    }

    public static void removedCorectly(){
        System.out.println("Value was successfully deleted");
    }

    public static void byeBye(){
        System.out.println(ConsoleColors.RED + "Bye, bye");
    }

    public static void badCommand(){
        System.out.println(ConsoleColors.RED + "Please pick correct command!" + ConsoleColors.RESET);
    }
}
