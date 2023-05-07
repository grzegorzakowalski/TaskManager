package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;

public class FileReader  extends FileControl{
    public static String[] readFileToTable(){
        FileControl.createFile();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            for (String s : Files.readAllLines(path)){
                stringBuilder.append(s).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String wholeFile = stringBuilder.toString();


        return wholeFile.split("\n");
    }




}
