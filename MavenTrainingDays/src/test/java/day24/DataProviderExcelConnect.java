package day24;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderExcelConnect {
	
	@DataProvider
	public String[][] getData() throws IOException {

	    File file = new File("D:\\Programming\\Ecilipse\\MavenTrainingDays\\src\\test\\java\\DataProvider.xlsx");
	    System.out.println(file.exists());

	    FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);

	    XSSFSheet sheet = workbook.getSheetAt(0);

	    int rows = sheet.getPhysicalNumberOfRows();
	    int cols = sheet.getRow(0).getLastCellNum();

	    String[][] data = new String[rows - 1][cols]; // excluding header

	    DataFormatter df = new DataFormatter();

	    for (int i = 0; i < rows - 1; i++) {   // FIXED: loop till rows-1
	        for (int j = 0; j < cols; j++) {
	            data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
	        }
	    }

	    workbook.close();
	    fis.close();

	    return data;
	}

}
