package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WorkingWithExcel {
    public static void main(String[] args) throws IOException {
        String filepath = "C:\\Project\\ExcelData\\StudentExcelData\\StudentExcel.xlsx";

        Scanner scn = new Scanner(System.in);
        //writeExcel(filepath,scn);
        readExcel(filepath);
        //updateExcel(filepath,scn);
        addingDataToExcel(filepath,scn);

    }


    private static void writeExcel(String filepath, Scanner scn) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Student_ID");
        header.createCell(1).setCellValue("Student_Name");
        header.createCell(2).setCellValue("Student_Marks");

        System.out.print("Enter no. of Records : ");
        int recordCount = scn.nextInt();
        for (int i=1;i<=recordCount;i++){
            Row row = sheet.createRow(i);
            System.out.print("Enter id of the Student " + i + ": ");
            int id = scn.nextInt();

            scn.nextLine();
            System.out.print("Enter name of the Student " + i + ": ");
            String name = scn.nextLine();

            System.out.print("Enter marks of the Student " + i + ": ");
            int marks = scn.nextInt();
            row.createCell(0).setCellValue(id);
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(marks);

        }

        try(FileOutputStream fileOutputStream = new FileOutputStream(filepath)){
            workbook.write(fileOutputStream);
            System.out.println("Excel file written successfully");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private static void readExcel(String filepath) throws IOException{
        try (FileInputStream inputStream = new FileInputStream(filepath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)){
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet){
                for (Cell cell:row){
                    switch (cell.getCellType()){
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            break;
                    }
                }
                System.out.println();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    private static void updateExcel(String filepath, Scanner scn) throws IOException{
        try (FileInputStream inputStream = new FileInputStream(filepath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)){
            XSSFSheet sheet = workbook.getSheetAt(0);

            System.out.println("Enter ID of the Student to update record");
            int idToUpdate = scn.nextInt();

            boolean recordFound = false;

            scn.nextLine();
            for (Row row : sheet){
                Cell idCell = row.getCell(0);
                if(idCell != null && idCell.getCellType()== CellType.NUMERIC){
                    if(idCell.getNumericCellValue() == idToUpdate){
                        System.out.print("Enter New Name : ");
                        String newName = scn.nextLine();
                        Cell nameCell = row.getCell(1);
                        nameCell.setCellValue(newName);

                        System.out.print("Enter New Marks : ");
                        int newMarks = scn.nextInt();
                        Cell marksCell = row.getCell(2);
                        marksCell.setCellValue(newMarks);
                        recordFound = true;
                        break;
                    }
                }
            }

            if(recordFound) {
                try (FileOutputStream outputStream = new FileOutputStream(filepath)) {
                    workbook.write(outputStream);
                    System.out.println("Excel file updated successfully");
                }
            }else {
                System.out.println("Record not found with id " + idToUpdate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void addingDataToExcel(String filepath, Scanner scn) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filepath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            XSSFSheet sheet = workbook.getSheetAt(0);

            int lastRowNumber = sheet.getPhysicalNumberOfRows();
            System.out.print("enter number of members data you want to add : ");
            int members = scn.nextInt();

            for(int i=0;i<members;i++){
                Row row = sheet.createRow(lastRowNumber);
                System.out.print("id : ");
                int id = scn.nextInt();
                System.out.print("name : ");
                scn.nextLine();
                String name = scn.nextLine();
                System.out.print("marks : ");
                int marks = scn.nextInt();

                row.createCell(0).setCellValue(id);
                row.createCell(1).setCellValue(name);
                row.createCell(2).setCellValue(marks);
                lastRowNumber++;
            }
            try(FileOutputStream fileOutputStream = new FileOutputStream(filepath)){
                workbook.write(fileOutputStream);
                System.out.println("Excel file data added successfully");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}