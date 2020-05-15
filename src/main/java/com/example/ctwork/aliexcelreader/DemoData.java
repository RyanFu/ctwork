package com.example.ctwork.aliexcelreader;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author yicg
 * @createTime 2020年05月08日 17:35:00
 * @Description
 */
@Data
public class DemoData {
        @ExcelProperty("用户user_id")
        private String uid;
        @ExcelProperty("用户姓名name")
        private String name;
        @ExcelProperty("用户idCard")
        private String idCard;
        @ExcelProperty("用户手机号mobile")
        private String mobile;
        @ExcelProperty("颜值贷字段var_name")
        private String varName;
        @ExcelProperty("颜值贷字段描述desc")
        private String desc;
        @ExcelProperty("字段返回结果")
        private String result;
        @ExcelProperty("字段请求时间")
        private String nowTime;


        /**
         * 忽略这个字段
         */
        @ExcelIgnore
        private String ignore;


}
