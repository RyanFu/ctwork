package com.example.ctwork.aliexcelreader;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author yicg
 * @createTime 2020年05月07日 13:53:00
 * @Description   以对象形式返回
 */
@Slf4j
public class EasyExcelUtils {
    /**
     * 读取excel
     *
     * @param fileName  excel存放路径
     * @param sheetName 要读取的sheet名称
     * @param rowNum    从第几行开始读
     * @return
     */
    public static List<Domain> readExcelWithSheet(String fileName, String sheetName, int rowNum) {
        EasyExcelListener easyListener = new EasyExcelListener(new ArrayList<>());
        EasyExcel.read(fileName, Domain.class, easyListener).headRowNumber(rowNum).sheet(sheetName).doRead();
        List<Domain> data = easyListener.getData();
        return data;
    }

    /**
     * 对象写入excel
     *
     * @param data 要写入的对象
     * @param path 要写入的路径
     */
    public static void writeExcelWithSheet(List<DemoData> data, String path) {
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(path,DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("颜值贷测试").build();
        excelWriter.write(data, writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }
}
