package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
    private Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public String getCellData(int row, int col) {
        Row r = sheet.getRow(row);
        Cell c = r.getCell(col);
        return c.toString();
    }
}
