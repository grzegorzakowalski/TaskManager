package pl.coderslab;





import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        boolean isWhileRunning = true;
        Scanner scanner = new Scanner(System.in);
        TableControl tableControl = new TableControl();


        while (isWhileRunning) {
            tableControl.setFileArray(FileReader.readFileToTable());
            Menu.printOptions();
            String command = scanner.nextLine();
            command = command.trim();
            switch (command) {
                case "add" -> {
                    tableControl.addTask(Menu.getTaskFromUser());
                    FileWriter.writeTableToFile(tableControl.getFileArray());
                }
                case "remove" -> {
                    int taskNumber = Menu.getTaskNumberFromUser();
                    if (taskNumber >= 0 && taskNumber < tableControl.getLength()) {
                        tableControl.removeTask(taskNumber);
                        FileWriter.writeTableToFile(tableControl.getFileArray());
                        Menu.removedCorectly();
                    } else {
                        Menu.badInput();
                    }
                }
                case "list" -> tableControl.printFileArray();
                case "exit" -> {
                    isWhileRunning = false;
                    Menu.byeBye();
                }
                default -> Menu.badCommand();
            }

        }


    }
}

//    public static boolean createFile() throws IOException {
//        Path path = Paths.get(fileName);
//        if(!Files.exists(path)){
//            try {
//                Files.createFile(path);
//                Files.writeString(path, "0 ");
//            } catch (IOException e) {
//                throw new IOException();
//            }
//            return true;
//        }
//        return false;
//    }

    //public static void printOptions(){
      //  System.out.println(ConsoleColors.BLUE +"Please select an option:" + ConsoleColors.RESET);
       // System.out.println("add");
       // System.out.println("remove");
       // System.out.println("list");
       // System.out.println("exit");
    //}

//    public static String[] getDataFromLibrary(){
//        Path path = Paths.get(fileName);
//        try {
//            boolean wasFileCreated = createFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        try {
//            for (String s : Files.readAllLines(path)){
//                stringBuilder.append(s).append("\n");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        String wholeFile = stringBuilder.toString();
//        String[] everyRowFromFile = wholeFile.split("\n");
//
//
//
//        return everyRowFromFile;
//    }

//    public static void add(){
//        String[] data = getDataFromLibrary();
//        Scanner scanner = new Scanner(System.in);
//        String line = "";
//        Path path = Paths.get(fileName);
//
//
//        System.out.println("Please add task description");
//        line += StringUtils.trim(scanner.nextLine()) + " ";
//
//        System.out.println("Please add task due date");
//        line += StringUtils.trim(scanner.nextLine()) + " ";
//
//        System.out.println("Is your task important: true/false");
//        line += StringUtils.trim(scanner.nextLine());
//
//        try {
//            Files.writeString(path, line + "\n" + data.length + " ", StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    public static void list(){
//        String[] data = getDataFromLibrary();
//        if( data[0].equals("0 ") || data[0].equals("0")){
//            System.out.println("List is empty");
//        } else {
//            for (int i = 0; i < data.length -1; i++){
//                System.out.println(data[i]);
//            }
//        }
//    }
//
//    public static void remove(){
//        String[] data = getDataFromLibrary();
//        Scanner scanner = new Scanner(System.in);
//        Path path = Paths.get(fileName);
//        int whichLineParsed = -1;
//        boolean wrongInput = true;
//
//
//
//        System.out.println("Please select number to remove.");
//        while (wrongInput){
//            String whichLine = scanner.nextLine();
//        if (NumberUtils.isParsable(whichLine)){
//            whichLineParsed = Integer.parseInt(whichLine);
//        }
//        if( whichLineParsed >= 0 && whichLineParsed < data.length){
//            wrongInput = false;
//        }
//        if( wrongInput) {
//            System.out.println("Incorrect argument passed. Try again");
//        }
//
//
//        if ( whichLineParsed < data.length - 1 && whichLineParsed > 0){
//            try {
//                Files.writeString( path, data[0] + "\n");
//                for (int i = 1; i < whichLineParsed; i++){
//                    Files.writeString(path, data[i] + "\n", StandardOpenOption.APPEND);
//                }
//                for (int i = whichLineParsed + 1 ; i < data.length; i++){
//                    Files.writeString(path, i - 1 + data[i].substring(1) + "\n",StandardOpenOption.APPEND);
//                }
//                System.out.println("Value was successfully removed");
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else if ( whichLineParsed == 0){
//            try {
//                Files.writeString(path, "0" + data[1].substring(1) + "\n");
//                for (int i = whichLineParsed + 2; i < data.length; i++) {
//                    Files.writeString(path, i - 1 + data[i].substring(1) + "\n", StandardOpenOption.APPEND);
//                }
//                System.out.println("Value was successfully removed");
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        }
//        }


