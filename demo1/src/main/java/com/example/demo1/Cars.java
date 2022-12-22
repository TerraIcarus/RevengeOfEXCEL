package com.example.demo1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Cars {
    public static Object readExcel() throws IOException, SQLException {

        File file = new File("C:\\Users\\Admin\\Desktop\\cars.xlsx");

        Connection conn = Connect.Connect();
        Statement stmt=conn.createStatement();

        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows=sheet.getLastRowNum();

        for(int i=0;i<=rows;i++)
        {
            XSSFRow row=sheet.getRow(i);
            double value=row.getCell(0).getNumericCellValue();
            String name=row.getCell(1).getStringCellValue();

            String query  = "INSERT INTO public.\"ExcelCars\" (value, name) VALUES ('"+value+"','"+name+"');";
            System.out.println(query);
            stmt.execute(query);
        }

        workbook.close();
        fis.close();
        conn.close();

        return null;
    }
}