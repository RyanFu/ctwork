package com.example.model;

import java.util.Date;

public class AutoTestCaseWithBLOBs extends AutoTestCase {
    private String heads;

    private String param;

    private String actualResult;


    public AutoTestCaseWithBLOBs(Integer id, String caseName, String host, Integer port, String uri, String method, String paramType, String state, Date creatTime, Date updateTime, String heads, String param, String actualResult) {
        super(id, caseName, host, port, uri, method, paramType, state, creatTime, updateTime);
        this.heads = heads;
        this.param = param;
        this.actualResult = actualResult;
    }

    public AutoTestCaseWithBLOBs() {
        super();
    }

    public String getHeads() {
        return heads;
    }

    public void setHeads(String heads) {
        this.heads = heads == null ? null : heads.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult == null ? null : actualResult.trim();
    }


    @Override
    public String toString() {
        return "AutoTestCaseWithBLOBs{" +
                "heads='" + heads + '\'' +
                ", param='" + param + '\'' +
                ", actualResult='" + actualResult + '\'' +
                '}';
    }
}