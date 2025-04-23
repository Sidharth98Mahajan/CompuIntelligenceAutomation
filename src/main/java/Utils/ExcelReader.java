package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static Object[][] getLoginData() throws IOException {
        // Specify the path to your Excel file
        String filePath = "C:\\Users\\Sidharath\\eclipse-workspace\\CompuIntelligence\\src\\main\\java\\TestData\\LoginData.xlsx";
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols]; // Data for DataProvider

        for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
            for (int j = 0; j < cols; j++) {
                // Check if the cell is empty (null) and handle it
                Cell cell = sheet.getRow(i).getCell(j);
                if (cell == null) {
                    data[i - 1][j] = ""; // Assign empty string if cell is null
                } else {
                    data[i - 1][j] = cell.toString(); // Otherwise, convert cell value to string
                }
            }
        }

        workbook.close();
        fis.close();
        return data; // Return the data in Object[][] format for DataProvider
    }

	public static Object[][] getUserdata() throws IOException {
		 // Specify the path to your Excel file
        String filePath = "C:\\Users\\Sidharath\\eclipse-workspace\\CompuIntelligence\\src\\main\\java\\TestData\\UserManagement.xlsx";
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols]; // Data for DataProvider

        for (int i = 1; i < rows; i++) { // Start from 1 to skip the header row
            for (int j = 0; j < cols; j++) {
                // Check if the cell is empty (null) and handle it
                Cell cell = sheet.getRow(i).getCell(j);
                if (cell == null) {
                    data[i - 1][j] = ""; // Assign empty string if cell is null
                } else {
                    data[i - 1][j] = cell.toString(); // Otherwise, convert cell value to string
                }
            }
        }

        workbook.close();
        fis.close();
        return data; // Return the data in Object[][] format for DataProvider
	}
}
