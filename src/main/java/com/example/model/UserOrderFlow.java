package com.example.model;

public class UserOrderFlow {

  private Integer id;
  private Integer orderId;
  private String orderNo;
  private String serialNo;
  private String transType;
  private double amount;
  private double accAmount;
  private String descCode;
  private String desc;
  private String tradeTime;
  private String tradeDetail;
  private java.sql.Date gmtCreate;


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


  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }


  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }


  public String getTransType() {
    return transType;
  }

  public void setTransType(String transType) {
    this.transType = transType;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public double getAccAmount() {
    return accAmount;
  }

  public void setAccAmount(double accAmount) {
    this.accAmount = accAmount;
  }


  public String getDescCode() {
    return descCode;
  }

  public void setDescCode(String descCode) {
    this.descCode = descCode;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  public String getTradeTime() {
    return tradeTime;
  }

  public void setTradeTime(String tradeTime) {
    this.tradeTime = tradeTime;
  }


  public String getTradeDetail() {
    return tradeDetail;
  }

  public void setTradeDetail(String tradeDetail) {
    this.tradeDetail = tradeDetail;
  }


  public java.sql.Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(java.sql.Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

}
