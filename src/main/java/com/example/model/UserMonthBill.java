package com.example.model;

public class UserMonthBill {

  private Integer id;
  private Integer userId;
  private String monthTime;
  private String mobile;
  private String name;
  private Integer orderNumber;
  private Integer orderSpendNumber;
  private Integer orderRefundNumber;
  private double totalAmount;
  private double totalSpendAmount;
  private double totalRefundAmount;
  private double interest;
  private double repayAmount;
  private double discountAmount;
  private String state;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;
  private java.sql.Date beginTime;
  private java.sql.Date finishTime;
  private double lateFee;
  private double penaltyFee;
  private double totalOverdueInterest;
  private String billBegins;
  private String billEnds;
  private Integer sendMessage;
  private double rebateAmount;
  private String repayState;


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


  public String getMonthTime() {
    return monthTime;
  }

  public void setMonthTime(String monthTime) {
    this.monthTime = monthTime;
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


  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }


  public Integer getOrderSpendNumber() {
    return orderSpendNumber;
  }

  public void setOrderSpendNumber(Integer orderSpendNumber) {
    this.orderSpendNumber = orderSpendNumber;
  }


  public Integer getOrderRefundNumber() {
    return orderRefundNumber;
  }

  public void setOrderRefundNumber(Integer orderRefundNumber) {
    this.orderRefundNumber = orderRefundNumber;
  }


  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }


  public double getTotalSpendAmount() {
    return totalSpendAmount;
  }

  public void setTotalSpendAmount(double totalSpendAmount) {
    this.totalSpendAmount = totalSpendAmount;
  }


  public double getTotalRefundAmount() {
    return totalRefundAmount;
  }

  public void setTotalRefundAmount(double totalRefundAmount) {
    this.totalRefundAmount = totalRefundAmount;
  }


  public double getInterest() {
    return interest;
  }

  public void setInterest(double interest) {
    this.interest = interest;
  }


  public double getRepayAmount() {
    return repayAmount;
  }

  public void setRepayAmount(double repayAmount) {
    this.repayAmount = repayAmount;
  }


  public double getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(double discountAmount) {
    this.discountAmount = discountAmount;
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


  public java.sql.Date getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(java.sql.Date beginTime) {
    this.beginTime = beginTime;
  }


  public java.sql.Date getFinishTime() {
    return finishTime;
  }

  public void setFinishTime(java.sql.Date finishTime) {
    this.finishTime = finishTime;
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


  public String getBillBegins() {
    return billBegins;
  }

  public void setBillBegins(String billBegins) {
    this.billBegins = billBegins;
  }


  public String getBillEnds() {
    return billEnds;
  }

  public void setBillEnds(String billEnds) {
    this.billEnds = billEnds;
  }


  public Integer getSendMessage() {
    return sendMessage;
  }

  public void setSendMessage(Integer sendMessage) {
    this.sendMessage = sendMessage;
  }


  public double getRebateAmount() {
    return rebateAmount;
  }

  public void setRebateAmount(double rebateAmount) {
    this.rebateAmount = rebateAmount;
  }


  public String getRepayState() {
    return repayState;
  }

  public void setRepayState(String repayState) {
    this.repayState = repayState;
  }

}
