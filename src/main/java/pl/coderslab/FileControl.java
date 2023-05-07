package pl.coderslab;

import java.io.IOException;
import java.nio.file.*;

public class FileControl {
    protected static final String FILE_NAME = "tasks.csv";
    protected static Path path = Paths.get(FILE_NAME);

    protected static void createFile(){
        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
