package commons;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by hbhardwa on 7/6/2016.
 */
public class ReadXL {

    public static void main(String[] args) throws IOException {

        InputStream ReadXL = new FileInputStream("C:\\Users\\hbhardwa\\Desktop\\OCA8\\Parameterize.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(ReadXL);
        XSSFSheet sheet = wb.getSheet("Data");
        XSSFRow row;
        XSSFCell cell;

        Iterator IterateOnRows = sheet.rowIterator();

        while (IterateOnRows.hasNext()) {
            row = (XSSFRow) IterateOnRows.next();

            Iterator IterateOnCells = row.cellIterator();

            while(IterateOnCells.hasNext()) {
                cell = (XSSFCell) IterateOnCells.next();


                // Code above here enables the script to read the XL file.
                // Code below here performs functions on the data read from the XL file.


                if(cell.getCellType() ==  XSSFCell.CELL_TYPE_STRING) {
                    System.out.println(cell.getStringCellValue());
                }
                else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
                        System.out.println(cell.getNumericCellValue());
                }

                else
                    System.out.println("No Values Present");
            }

            System.out.println();

            }
        }
    }


