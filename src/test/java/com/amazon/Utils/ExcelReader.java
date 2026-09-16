package com.amazon.Utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {


    @DataProvider(name = "UsernameExcel")
    public static Object[][] excelRead(String filename) throws IOException {
        Object[][] data = null;

        FileInputStream fis = new FileInputStream(filename);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        data = new Object[sheet.getLastRowNum()][1];
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            String username = sheet.getRow(i).getCell(0).toString();
            String passwords= sheet.getRow(i).getCell(1).toString();

            map.put("Username", username);
            map.put("Password" , passwords);

            data[i][0] = map;
        }

        return data;


    }


}
