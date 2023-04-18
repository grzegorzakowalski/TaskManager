package pl.coderslab;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

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






        while (isWhileRunning){
            String[] data = getDataFromLibrary();
            printOptions();
            String command = scanner.nextLine();
            if( command.equals("add")){
                add();
            } else if (command.equals("remove")) {
                if ( data.length > 1) {
                    remove();
                } else {
                    System.out.println("There is nothing to remove");
                }
            } else if (command.equals("list")) {
                list();
            } else if (command.equals("exit")) {
                isWhileRunning = false;
                System.out.println(ConsoleColors.RED + "Bye, bye");
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
        if( data[0].equals("0 ") || data[0].equals("0")){
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < data.length -1; i++){
                System.out.println(data[i]);
            }
        }
    }

    public static void remove(){
        String[] data = getDataFromLibrary();
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get(fileName);
        int whichLineParsed = -1;
        boolean wrongInput = true;



        System.out.println("Please select number to remove.");
        while (wrongInput){
            String whichLine = scanner.nextLine();
        if (NumberUtils.isParsable(whichLine)){
            whichLineParsed = Integer.parseInt(whichLine);
        }
        if( whichLineParsed >= 0 && whichLineParsed < data.length){
            wrongInput = false;
        }
        if( wrongInput) {
            System.out.println("Incorrect argument passed. Try again");
        }


        if ( whichLineParsed < data.length - 1 && whichLineParsed > 0){
            try {
                Files.writeString( path, data[0] + "\n");
                for (int i = 1; i < whichLineParsed; i++){
                    Files.writeString(path, data[i] + "\n", StandardOpenOption.APPEND);
                }
                for (int i = whichLineParsed + 1 ; i < data.length; i++){
                    Files.writeString(path, i - 1 + data[i].substring(1) + "\n",StandardOpenOption.APPEND);
                }
                System.out.println("Value was successfully removed");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ( whichLineParsed == 0){
            try {
                Files.writeString(path, "0" + data[1].substring(1) + "\n");
                for (int i = whichLineParsed + 2; i < data.length; i++) {
                    Files.writeString(path, i - 1 + data[i].substring(1) + "\n", StandardOpenOption.APPEND);
                }
                System.out.println("Value was successfully removed");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        }
        }


}