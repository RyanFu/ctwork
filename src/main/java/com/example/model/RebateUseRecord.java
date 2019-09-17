package com.example.model;

public class RebateUseRecord {

  private Integer id;
  private Integer userId;
  private Integer rebateHistoryId;
  private Integer refRebateHistoryId;
  private String type;
  private double amount;
  private double balance;
  private java.sql.Date gmtCreate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getRebateHistoryId() {
    return rebateHistoryId;
  }

  public void setRebateHistoryId(Integer rebateHistoryId) {
    this.rebateHistoryId = rebateHistoryId;
  }


  public Integer getRefRebateHistoryId() {
    return refRebateHistoryId;
  }

  public void setRefRebateHistoryId(Integer refRebateHistoryId) {
    this.refRebateHistoryId = refRebateHistoryId;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }


  public java.sql.Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(java.sql.Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

}
