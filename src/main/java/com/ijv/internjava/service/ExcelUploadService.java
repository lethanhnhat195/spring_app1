package com.ijv.internjava.service;

import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.model.entity.WorkShift;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValueExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.speadsheetml.sheet");
    }
    public static List<Employee> getEmployeeDataFromExcel(InputStream inputStream) {
        List<Employee> employees = new ArrayList<>();
        try {
            XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workBook.getSheet("employees");

            int rowIndex = 0;
            for(Row row: sheet){
                if(rowIndex == 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Employee employee = new Employee();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 0 -> employee.setId((long) cell.getNumericCellValue());
                        case 1 -> employee.setName(cell.getStringCellValue());
                        case 2 -> employee.setGender(cell.getBooleanCellValue());
                        case 3 -> employee.setBirthday(cell.getDateCellValue());
                        case 4 -> employee.setPhone(cell.getStringCellValue());
                        case 5 -> employee.setAddress(cell.getStringCellValue());
                        case 6 -> employee.setEmail(cell.getStringCellValue());
                        case 7 -> employee.setImage(cell.getStringCellValue());
                        case 8 -> employee.setUserName(cell.getStringCellValue());
                        case 9 -> employee.setPassword(cell.getStringCellValue());
                        case 10 -> employee.setWorkShift(new WorkShift((long) cell.getNumericCellValue()));
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                employees.add(employee);
            }
        }catch (IOException e){
            e.getStackTrace();
        }
        return employees;
    }
}
