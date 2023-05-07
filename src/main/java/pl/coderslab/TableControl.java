package pl.coderslab;

import java.util.Arrays;

public class TableControl {

    private String[] fileArray;

    public TableControl(){
        fileArray = new String[0];
    }

    public void removeTask(int task){
        String[] newArray = new String[fileArray.length -1];
        int j = 0;
        for (int i = 0; i < fileArray.length; i++) {
            if( i != task){
                newArray[j] = fileArray[i];
                j++;
            }

        }
        fileArray = newArray;
    }

    public void setFileArray(String[] fileArray){
        this.fileArray = fileArray;
    }

    public void addTask(String task){
        if( fileArray[0].equals("null")){
            fileArray[0] = task;
        } else {

            String[] newArray = Arrays.copyOf(fileArray, fileArray.length + 1);
            newArray[newArray.length - 1] = task;
            fileArray = newArray;
        }
    }

    public void printFileArray(){
        if( fileArray[0].equals("null")){
            System.out.println("List is empty");
        }else {
            for (int i = 0; i < fileArray.length; i++) {
                System.out.println(String.format("%s : %s", i, fileArray[i]));
            }
        }
    }

    public int getLength(){
        return fileArray.length;
    }
    public String[] getFileArray(){
        return fileArray;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : fileArray) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
