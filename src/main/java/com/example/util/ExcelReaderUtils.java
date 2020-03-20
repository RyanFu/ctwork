package com.example.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取excel文件并解析
 */
@Slf4j
public class ExcelReaderUtils {

    public static XSSFSheet ExcelWSheet;
    public static XSSFWorkbook ExcelWBook;
    public static XSSFCell Cell;
    public static XSSFRow Row;

    public static String[][] getExpectationData(String file, String sheetName) {

        try {
            FileInputStream ExcelFile = new FileInputStream(file);//获取Excel文件
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            // 得到工作表名称
            ExcelWSheet = ExcelWBook.getSheet(sheetName);
            // 得到总行数
            int rowNum = ExcelWSheet.getLastRowNum();
            List<String[]> results = new ArrayList<String[]>();
            for (int i = 1; i <= rowNum; i++) {
                // 当前行
                XSSFRow row = ExcelWSheet.getRow(i);
                int colNum = row.getLastCellNum();
                String[] data = new String[colNum];
                // 当前行所有列
                for (int j = 0; j < colNum; j++) {
                    try {
                        data[j] = getCellValue(row.getCell(j));
                    } catch (NullPointerException e) { // 如果单元格为空的时候，则用这个来处理
                        data[j] = "";
                    }
                }
                // 把data[]数组的数据存在list<[]>中
                results.add(data);
            }
            String[][] returnArray = new String[results.size()][rowNum];
            for (int i = 0; i < returnArray.length; i++) {
                returnArray[i] = (String[]) results.get(i);
            }
            return returnArray;

        }catch (Exception e){
            return null;
        }

    }

    /**
     * 对Excel的各个单元格的格式进行判断并转换
     */
    private static String getCellValue(XSSFCell xssfCell) {
        String cellValue = "";
        DecimalFormat df = new DecimalFormat("#");
        switch (xssfCell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = xssfCell.getRichStringCellValue().getString().trim();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                cellValue = df.format(xssfCell.getNumericCellValue()).toString();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(xssfCell.getBooleanCellValue()).trim();
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                cellValue = xssfCell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }


    /**
     *   写入excel
     * @param list
     * @param filePath
     */
    public static void writeExcel(List<List<String>> list, String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        Workbook workbook = null;
        if (fileName.endsWith("xls")) {
            log.error("请创建xlsx结尾的文件");
        } else if (fileName.endsWith("xlsx")) {
            workbook = xssfWriteExcel(list);
        }
        //将文件保存到指定的位置
        try {
            OutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            //System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 把内容写入Excel
     *
     * @param list 传入要写的内容，此处以一个List内容为例，先把要写的内容放到一个list中
     */
    private static XSSFWorkbook xssfWriteExcel(List<List<String>> list) {
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();

        //创建工作表
        XSSFSheet xssfSheet = workbook.createSheet();

        //创建行
        XSSFRow xssfRow;

        //创建列，即单元格Cell
        XSSFCell xssfCell;

        //把List里面的数据写到excel中
        for (int i = 0; i < list.size(); i++) {
            //从第一行开始写入
            xssfRow = xssfSheet.createRow(i);
            //创建每个单元格Cell，即列的数据
            List sub_list = list.get(i);
            for (int j = 0; j < sub_list.size(); j++) {
                xssfCell = xssfRow.createCell(j); //创建单元格
                xssfCell.setCellValue((String) sub_list.get(j)); //设置单元格内容
            }
        }
        return workbook;

    }






}
