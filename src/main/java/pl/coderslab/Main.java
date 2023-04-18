package pl.coderslab;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static final String fileName = "tasks.csv";


    public static void main(String[] args) throws IOException {
        boolean isWhileRunning = true;
        Scanner scanner = new Scanner(System.in);


        //String[] dataFromLibrary = getDataFromLibrary();



        while (isWhileRunning){
            printOptions();
            String command = scanner.nextLine();
            if( command.equals("add")){
                add();
            } else if (command.equals("remove")) {
                // TODO remove metod
            } else if (command.equals("list")) {
                list();
            } else if (command.equals("exit")) {
                isWhileRunning = false;
            } else {
                System.out.println(ConsoleColors.RED + "Please pick correct command!" + ConsoleColors.RESET);
            }

        }


    }

    public static boolean createFile() throws IOException {
        Path path = Paths.get(fileName);
        if(!Files.exists(path)){
            try {
                Files.createFile(path);
                Files.writeString(path, "0 ");
            } catch (IOException e) {
                throw new IOException();
            }
            return true;
        }
        return false;
    }

    public static void printOptions(){
        System.out.println(ConsoleColors.BLUE +"Please select an option:" + ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("exit");
    }

    public static String[] getDataFromLibrary(){
        Path path = Paths.get(fileName);
        try {
            boolean wasFileCreated = createFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder stringBuilder = new StringBuilder();

        try {
            for (String s : Files.readAllLines(path)){
                stringBuilder.append(s).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String wholeFile = stringBuilder.toString();
        String[] everyRowFromFile = wholeFile.split("\n");



        return everyRowFromFile;
    }

    public static void add(){
        String[] data = getDataFromLibrary();
        Scanner scanner = new Scanner(System.in);
        String line = "";
        Path path = Paths.get(fileName);


        System.out.println("Please add task description");
        line += StringUtils.trim(scanner.nextLine()) + " ";

        System.out.println("Please add task due date");
        line += StringUtils.trim(scanner.nextLine()) + " ";

        System.out.println("Is your task important: true/false");
        line += StringUtils.trim(scanner.nextLine());

        try {
            Files.writeString(path, line + "\n" + data.length + " ", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void list(){
        String[] data = getDataFromLibrary();
        if( data[0].equals("0 ")){
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < data.length -1; i++){
                System.out.println(data[i]);
            }
        }
    }


}