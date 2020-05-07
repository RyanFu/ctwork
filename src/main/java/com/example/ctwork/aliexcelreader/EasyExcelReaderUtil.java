package com.example.ctwork.aliexcelreader;

import com.alibaba.excel.EasyExcel;

import java.util.*;

/**
 * @author yicg
 * @createTime 2020年05月07日 13:53:00
 * @Description   以对象形式返回
 */
public class EasyExcelReaderUtil {

    public static List<Domain> readExcelWithSheet(String fileName, String sheetName, int rowNum){
        EasyExcelListener easyListener=new EasyExcelListener(new ArrayList<Domain>());
        EasyExcel.read(fileName, Domain.class, easyListener).headRowNumber(rowNum).sheet(sheetName).doRead();
        List<Domain> data = easyListener.getData();
        return data;
    }

    public static void main(String[] args) {
        String s="/Users/yicg/IdeaProjects/ctwork/src/main/TestData/数据copy.xlsx";
        List<Domain> list=readExcelWithSheet(s,"test002",1);
        for (Domain domain:list
             ) {
            System.out.println(domain.getVarName()+" "+" "+domain.getDesc()+" "+domain.getMessage());
        }
    }
}
