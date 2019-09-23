package com.example.demo;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import java.io.FileInputStream;

/**
 * @author yicg
 * @date 2019-09-22 17:52
 */

public class ExcelReader {

    public static void main(String[] args) {

        XSSFWorkbook excelWBook;
        XSSFSheet excelWSheet;
        XSSFCell cell;

        String path="G:\\com\\testEcxcel\\src\\main\\TestData\\test.xlsx";
        String sheetName="login";

        try {
            FileInputStream excelFile=new FileInputStream(path);
            excelWBook=new XSSFWorkbook(excelFile);
            excelWSheet=excelWBook.getSheet(sheetName);

            //取出第一行第一列的单元格
            cell=excelWSheet.getRow(1).getCell(3);
            String cellData=cell.getStringCellValue();
            JSONObject jsonObject=new JSONObject(cellData);
            System.out.println("单元格数据是="+cellData);
            System.out.println("单元格数据是="+jsonObject);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
