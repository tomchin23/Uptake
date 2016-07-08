package commons;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CORBA.portable.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by hbhardwa on 7/6/2016.
 */
public class WriteXL {

    public static void main(String[] args) throws IOException {

    // This will create an XL workbook and rename the first sheet once this code runs.
        String XLToWrite = "C:\\Users\\hbhardwa\\Desktop\\OCA\\WriteIntoXL.xlsx";
        String sheetName = "Data";

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName);
        XSSFRow row;
        XSSFCell cell;

        for (int r = 0; r < 5; r ++) {
            row = sheet.createRow(r);

            for (int c = 0; c < 5; c ++) {
                cell = row.createCell(c);

                cell.setCellValue("Hi");
            }

        }

        FileOutputStream fileOut = new FileOutputStream(XLToWrite);
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
}
