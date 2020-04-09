package com.example.model;

public class DataSourceWithBLOBs extends DataSource {
    private String bodyPattern;

    private String sampleOutput;

    public DataSourceWithBLOBs(Long id, String name, String enName, String description, Boolean isPublic, String callType, String urlPattern, String createBy, String updateBy, Long createAt, Long updateAt, Integer timeout, Long dataSourceAuthId, String bodyPattern, String sampleOutput) {
        super(id, name, enName, description, isPublic, callType, urlPattern, createBy, updateBy, createAt, updateAt, timeout, dataSourceAuthId);
        this.bodyPattern = bodyPattern;
        this.sampleOutput = sampleOutput;
    }

    public DataSourceWithBLOBs() {
        super();
    }

    public String getBodyPattern() {
        return bodyPattern;
    }

    public void setBodyPattern(String bodyPattern) {
        this.bodyPattern = bodyPattern == null ? null : bodyPattern.trim();
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput == null ? null : sampleOutput.trim();
    }

    @Override
    public String toString() {
        return "DataSourceWithBLOBs{" +
                "bodyPattern='" + bodyPattern + '\'' +
                ", sampleOutput='" + sampleOutput + '\'' +
                '}';
    }
}