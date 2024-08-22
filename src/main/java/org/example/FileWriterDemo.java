package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {

        String filePath = "C:\\Project\\demotextfile.txt";
        try(FileWriter fileWriter = new FileWriter(filePath)){
            fileWriter.write("Im a human");
            System.out.println("File written successfully");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
