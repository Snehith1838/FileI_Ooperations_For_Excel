package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class DirectorsData {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Project\\ExcelData\\DirectorsExcelData\\DirectorsDetails.xlsx";
        Scanner scn = new Scanner(System.in);

        try(FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream)){
            XSSFSheet sheet = workbook.getSheetAt(0);
            List<String> directrosList = new ArrayList<>();
            int k = 0;
            for (Row row:sheet){
                if(k == 0) {
                    String directorName = String.valueOf(row.getCell(0));
                    k++;
                }else {
                    String directorName = String.valueOf(row.getCell(0)).toUpperCase();
                    directrosList.add(directorName);
                }
            }
            Set<String> uniqueDirectorsSet = new HashSet<>(directrosList);
            List<String> uniqueDirectorsList = new ArrayList<>();
            for(String directors:uniqueDirectorsSet){
                uniqueDirectorsList.add(directors);
            }

            System.out.println(" ");
            System.out.println("Directors List :-");
            for(int i=0;i<uniqueDirectorsList.size();i++){
                System.out.println((i+1) + "." + uniqueDirectorsList.get(i));
            }

            System.out.println(" ");
            System.out.print("Select your favorite Director : ");
            int chooseDirector = scn.nextInt();
            String choosedDirectorName = uniqueDirectorsList.get(chooseDirector-1);

            System.out.println(" ");
            System.out.println("Director " + choosedDirectorName + " Movies :-");
            List<String> moviesList = new ArrayList<>();
            for(Row row:sheet){
                if (String.valueOf(row.getCell(0)).equalsIgnoreCase(choosedDirectorName)) {
                    moviesList.add(String.valueOf(row.getCell(1)));
                    System.out.println(row.getCell(1));
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
