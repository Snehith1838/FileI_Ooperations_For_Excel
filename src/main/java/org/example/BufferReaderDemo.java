package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {
    public static void main(String[] args) {
        String filePath = "C:\\Project\\demolargetextfile.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
