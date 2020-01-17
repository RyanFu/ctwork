package com.example.mbg;

import java.util.Date;

public class AutoTestCase {
    private Integer id;

    private String caseName;

    private String host;

    private Integer port;

    private String uri;

    private String method;

    private String paramType;

    private String state;

    private Date creatTime;

    private Date updateTime;

    public AutoTestCase(Integer id, String caseName, String host, Integer port, String uri, String method, String paramType, String state, Date creatTime, Date updateTime) {
        this.id = id;
        this.caseName = caseName;
        this.host = host;
        this.port = port;
        this.uri = uri;
        this.method = method;
        this.paramType = paramType;
        this.state = state;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    public AutoTestCase() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName == null ? null : caseName.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}