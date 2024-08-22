package org.example;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        String filePath = "C:\\Project\\demotextfile.txt";
        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
