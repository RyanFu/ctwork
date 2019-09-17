package com.example.model;

public class RebateHistory {

  private Integer id;
  private Integer userId;
  private Integer orderId;
  private double rebate;
  private double rawRebate;
  private double invalidRebate;
  private String type;
  private String status;
  private java.sql.Date rebateTime;
  private java.sql.Date validTo;
  private Integer deleted;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;


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


  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }


  public double getRebate() {
    return rebate;
  }

  public void setRebate(double rebate) {
    this.rebate = rebate;
  }


  public double getRawRebate() {
    return rawRebate;
  }

  public void setRawRebate(double rawRebate) {
    this.rawRebate = rawRebate;
  }


  public double getInvalidRebate() {
    return invalidRebate;
  }

  public void setInvalidRebate(double invalidRebate) {
    this.invalidRebate = invalidRebate;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public java.sql.Date getRebateTime() {
    return rebateTime;
  }

  public void setRebateTime(java.sql.Date rebateTime) {
    this.rebateTime = rebateTime;
  }


  public java.sql.Date getValidTo() {
    return validTo;
  }

  public void setValidTo(java.sql.Date validTo) {
    this.validTo = validTo;
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
