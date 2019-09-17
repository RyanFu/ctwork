package com.example.model;

public class OrderInterestRecord {

  private Integer id;
  private Integer orderId;
  private Integer userId;
  private String orderNo;
  private String dayTime;
  private String monthTime;
  private String workDate;
  private String cardIssuer;
  private String orderModel;
  private double totalAmount;
  private double principal;
  private String interestType;
  private double interestAmount;
  private double highInterest;
  private String beginDay;
  private String endDay;
  private Integer deleted;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }


  public String getDayTime() {
    return dayTime;
  }

  public void setDayTime(String dayTime) {
    this.dayTime = dayTime;
  }


  public String getMonthTime() {
    return monthTime;
  }

  public void setMonthTime(String monthTime) {
    this.monthTime = monthTime;
  }


  public String getWorkDate() {
    return workDate;
  }

  public void setWorkDate(String workDate) {
    this.workDate = workDate;
  }


  public String getCardIssuer() {
    return cardIssuer;
  }

  public void setCardIssuer(String cardIssuer) {
    this.cardIssuer = cardIssuer;
  }


  public String getOrderModel() {
    return orderModel;
  }

  public void setOrderModel(String orderModel) {
    this.orderModel = orderModel;
  }


  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }


  public double getPrincipal() {
    return principal;
  }

  public void setPrincipal(double principal) {
    this.principal = principal;
  }


  public String getInterestType() {
    return interestType;
  }

  public void setInterestType(String interestType) {
    this.interestType = interestType;
  }


  public double getInterestAmount() {
    return interestAmount;
  }

  public void setInterestAmount(double interestAmount) {
    this.interestAmount = interestAmount;
  }


  public double getHighInterest() {
    return highInterest;
  }

  public void setHighInterest(double highInterest) {
    this.highInterest = highInterest;
  }


  public String getBeginDay() {
    return beginDay;
  }

  public void setBeginDay(String beginDay) {
    this.beginDay = beginDay;
  }


  public String getEndDay() {
    return endDay;
  }

  public void setEndDay(String endDay) {
    this.endDay = endDay;
  }


  public Integer getDeleted() {
    return deleted;
  }

  public void setDeleted(Integer deleted) {
    this.deleted = deleted;
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
