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
        String filepath = "C:\\Project\\StudentExcelData\\StudentExcel.xlsx";

        Scanner scn = new Scanner(System.in);
        //writeExcel(filepath,scn);
        readExcel(filepath);
        //updateExcel(filepath,scn);

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
/*
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue(101);
        row1.createCell(1).setCellValue("Snehith");
        row1.createCell(2).setCellValue(92);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue(102);
        row2.createCell(1).setCellValue("Sai");
        row2.createCell(2).setCellValue(95);

        Row row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue(103);
        row3.createCell(1).setCellValue("Mahi");
        row3.createCell(2).setCellValue(98);

 */

        try(FileOutputStream fileOutputStream = new FileOutputStream(filepath)){
            workbook.write(fileOutputStream);
            System.out.println("Excel file written successfully");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private static void readExcel(String filepath) throws IOException{
        try (FileInputStream inputStream = new FileInputStream(filepath);
             XSSFWorkbook workbook = new XSSFWorkbook(filepath)){
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


//            Row row = sheet.getRow(1);
//            Cell cell = row.getCell(2);
//            cell.setCellValue(45);

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
}
