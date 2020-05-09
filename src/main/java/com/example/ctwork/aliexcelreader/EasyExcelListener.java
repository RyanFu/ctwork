package com.example.ctwork.aliexcelreader;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.ctwork.aliexcelreader.Domain;

import java.util.List;

/**
 * @author yicg
 * @createTime 2020年05月07日 13:30:00
 * @Description
 */
public class EasyExcelListener extends AnalysisEventListener<Domain> {
    private List<Domain> lists;


    public EasyExcelListener(List<Domain> lists) {
        this.lists = lists;
    }

    @Override
    public void invoke(Domain data, AnalysisContext context) {
        lists.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<Domain> getData() {
        return lists;
    }
}
