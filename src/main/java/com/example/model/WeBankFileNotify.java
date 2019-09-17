package com.example.model;

public class WeBankFileNotify {

  private Integer id;
  private String taskId;
  private String fileType;
  private String fileId;
  private String fileName;
  private Integer fileLineCount;
  private double totalAmount;
  private String workDate;
  private String retain;
  private String abstr;
  private String filePath;
  private Integer localCount;
  private Integer sameCount;
  private Integer unlikeCount;
  private Integer errorLineCount;
  private Integer localExtraCount;
  private Integer bankExtraCount;
  private String state;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }


  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }


  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public Integer getFileLineCount() {
    return fileLineCount;
  }

  public void setFileLineCount(Integer fileLineCount) {
    this.fileLineCount = fileLineCount;
  }


  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }


  public String getWorkDate() {
    return workDate;
  }

  public void setWorkDate(String workDate) {
    this.workDate = workDate;
  }


  public String getRetain() {
    return retain;
  }

  public void setRetain(String retain) {
    this.retain = retain;
  }


  public String getAbstr() {
    return abstr;
  }

  public void setAbstr(String abstr) {
    this.abstr = abstr;
  }


  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }


  public Integer getLocalCount() {
    return localCount;
  }

  public void setLocalCount(Integer localCount) {
    this.localCount = localCount;
  }


  public Integer getSameCount() {
    return sameCount;
  }

  public void setSameCount(Integer sameCount) {
    this.sameCount = sameCount;
  }


  public Integer getUnlikeCount() {
    return unlikeCount;
  }

  public void setUnlikeCount(Integer unlikeCount) {
    this.unlikeCount = unlikeCount;
  }


  public Integer getErrorLineCount() {
    return errorLineCount;
  }

  public void setErrorLineCount(Integer errorLineCount) {
    this.errorLineCount = errorLineCount;
  }


  public Integer getLocalExtraCount() {
    return localExtraCount;
  }

  public void setLocalExtraCount(Integer localExtraCount) {
    this.localExtraCount = localExtraCount;
  }


  public Integer getBankExtraCount() {
    return bankExtraCount;
  }

  public void setBankExtraCount(Integer bankExtraCount) {
    this.bankExtraCount = bankExtraCount;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public java.sql.Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(java.sql.Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }


  public java.sql.Date getGmtUpdate() {
    return gmtUpdate;
  }

  public void setGmtUpdate(java.sql.Date gmtUpdate) {
    this.gmtUpdate = gmtUpdate;
  }

}
