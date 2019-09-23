package com.example.demo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author yicg
 * @date 2019-09-22 18:50
 */
public class ExcelUtility {

    private static XSSFWorkbook ExcelWBook;
    private static XSSFSheet ExcelSheet;
    /**
     * 设置文件路径，打开excel
     */

    public static void setExcelFile(String path,String sheetName) throws Exception {


        try {
            //打开excel文件
            FileInputStream ExcelFile=new FileInputStream(new File(path));

            //访问excel表
            ExcelWBook=new XSSFWorkbook(ExcelFile);
            ExcelSheet=ExcelWBook.getSheet(sheetName);

        } catch (Exception e) {
           throw (e);
        }

    }


    public static String[][] getTestData(String tableName){
        String[][] testData=null;


        try {
            //处理单元格中的数字和字符串
            DataFormatter formatter=new DataFormatter();
            //BoundaryCells数组里放的是第一列和最后一列
            //根据第一列和最后一列，可以知道哪些行数据
            XSSFCell[] boundaryCells=findCells(tableName);
            //单元格开始处
            XSSFCell startCell=boundaryCells[0];
            //单元格结束处
            XSSFCell endCell=boundaryCells[1];

            //根据单元格开始找到开始行
            int startRow=startCell.getRowIndex()+1; //数据开始行
            int endRow=endCell.getRowIndex()-1;//数据结束行
            int startCol=startCell.getColumnIndex()+1;//数据开始列
            int endCol=endCell.getColumnIndex()-1;//数据结束列

            testData=new String[endRow - startRow+1][endCol - startCol+1];//定义二位数组长度

            for(int i=startRow;i<endRow+1;i++){
                for(int j=startCol;j<endCol+1;j++){

                    //取每一行里面的每一列的值
                    Cell cell=ExcelSheet.getRow(i).getCell(j);
                    testData[i-startRow][j-startCol]=formatter.formatCellValue(cell);

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

         return testData;

    }


    public static XSSFCell[] findCells(String tableName){

        DataFormatter formatter=new DataFormatter();
        String pos="begin";
        XSSFCell[] cells=new XSSFCell[2];

        for (Row row:ExcelSheet){
            for(Cell cell:row){

               // 只能取字符串类型     if(tableName.equals(cell.getStringCellValue())){
                //formatter.formatCellValue()既可以是字符串也可以是数字类型
                if (tableName.equals(formatter.formatCellValue(cell))){
                    if(pos.equalsIgnoreCase("begin")){
                        //找到开始单元格,用作边界单元格
                        cells[0]= (XSSFCell) cell;
                        pos="end";
                    }
                    else {
                        //找到结束单元格，用作边界单元格
                        cells[1]= (XSSFCell) cell;
                    }
                }
              }
            }

            return cells;
        }
    }
