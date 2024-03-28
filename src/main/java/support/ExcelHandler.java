package support;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ExcelHandler {
    public static Map<String, String > getTestDataInMap(String testDataFile, String sheetName, String key) {
        Map<String, String> testDataMap = new TreeMap<>();

        try(FileInputStream filename = new FileInputStream(testDataFile)){
            Workbook workbook = new XSSFWorkbook(filename);
            Sheet sheet = workbook.getSheet(sheetName);
            int count = sheet.getLastRowNum() - sheet.getFirstRowNum();
            ArrayList<String> headerRows = new ArrayList<>();
            for (int i = 0; i < count + 1; i++){
                Row row = sheet.getRow(i);
                if (i == 0){
                    for (int k = 0; k < row.getLastCellNum(); k++){
                        headerRows.add(row.getCell(k).getStringCellValue());
                    }
                }
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(key)){
                    for (int j = 0; j < row.getLastCellNum(); j++){
                        System.out.println("header: " + headerRows.get(j) +
                                " - value: " + row.getCell(j).getStringCellValue());
                        testDataMap.put(headerRows.get(j), row.getCell(j).getStringCellValue());
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return testDataMap;
    }
}
