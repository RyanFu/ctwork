package com.example.model;

public class UserRepayOrder {

  private Integer id;
  private Integer billId;
  private Integer userId;
  private String monthTime;
  private double totalAmount;
  private double repayAmount;
  private String state;
  private String stateDesc;
  private String version;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getBillId() {
    return billId;
  }

  public void setBillId(Integer billId) {
    this.billId = billId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getMonthTime() {
    return monthTime;
  }

  public void setMonthTime(String monthTime) {
    this.monthTime = monthTime;
  }


  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }


  public double getRepayAmount() {
    return repayAmount;
  }

  public void setRepayAmount(double repayAmount) {
    this.repayAmount = repayAmount;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getStateDesc() {
    return stateDesc;
  }

  public void setStateDesc(String stateDesc) {
    this.stateDesc = stateDesc;
  }


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
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
