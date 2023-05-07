package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileWriter extends FileControl {

    public static void writeTableToFile(String[] array){
        if( array != null && array.length > 0){
            try {
                Files.writeString(path, array[0] + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if( array.length >= 2){
                for (int i = 1; i < array.length; i++) {
                    try {
                        Files.writeString(path,array[i] + "\n", StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else {
            try {
                Files.writeString(path,"null");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }
}
