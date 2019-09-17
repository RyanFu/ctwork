package com.example.model;

public class UserPayBill {

  private Integer id;
  private Integer userId;
  private String bankCardNum;
  private Integer balanceAssetId;
  private String mobile;
  private String name;
  private double totalAmount;
  private double repayAmount;
  private String state;
  private String repayState;
  private Integer overdueDay;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;
  private java.sql.Date transStartTime;
  private java.sql.Date transEndTime;
  private java.sql.Date repaymentLastDay;
  private double lateFee;
  private double penaltyFee;
  private double totalOverdueInterest;


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


  public String getBankCardNum() {
    return bankCardNum;
  }

  public void setBankCardNum(String bankCardNum) {
    this.bankCardNum = bankCardNum;
  }


  public Integer getBalanceAssetId() {
    return balanceAssetId;
  }

  public void setBalanceAssetId(Integer balanceAssetId) {
    this.balanceAssetId = balanceAssetId;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


  public String getRepayState() {
    return repayState;
  }

  public void setRepayState(String repayState) {
    this.repayState = repayState;
  }


  public Integer getOverdueDay() {
    return overdueDay;
  }

  public void setOverdueDay(Integer overdueDay) {
    this.overdueDay = overdueDay;
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


  public java.sql.Date getTransStartTime() {
    return transStartTime;
  }

  public void setTransStartTime(java.sql.Date transStartTime) {
    this.transStartTime = transStartTime;
  }


  public java.sql.Date getTransEndTime() {
    return transEndTime;
  }

  public void setTransEndTime(java.sql.Date transEndTime) {
    this.transEndTime = transEndTime;
  }


  public java.sql.Date getRepaymentLastDay() {
    return repaymentLastDay;
  }

  public void setRepaymentLastDay(java.sql.Date repaymentLastDay) {
    this.repaymentLastDay = repaymentLastDay;
  }


  public double getLateFee() {
    return lateFee;
  }

  public void setLateFee(double lateFee) {
    this.lateFee = lateFee;
  }


  public double getPenaltyFee() {
    return penaltyFee;
  }

  public void setPenaltyFee(double penaltyFee) {
    this.penaltyFee = penaltyFee;
  }


  public double getTotalOverdueInterest() {
    return totalOverdueInterest;
  }

  public void setTotalOverdueInterest(double totalOverdueInterest) {
    this.totalOverdueInterest = totalOverdueInterest;
  }

}
