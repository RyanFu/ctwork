package com.example.model;

public class UserAccount {

  private Integer id;
  private Integer userId;
  private double amountTotal;
  private double amountUsed;
  private double amountFrozen;
  private double dailyLimit;
  private double monthLimit;
  private String state;
  private Integer active;
  private Integer deleted;
  private Integer grantFrequency;
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


  public double getAmountTotal() {
    return amountTotal;
  }

  public void setAmountTotal(double amountTotal) {
    this.amountTotal = amountTotal;
  }


  public double getAmountUsed() {
    return amountUsed;
  }

  public void setAmountUsed(double amountUsed) {
    this.amountUsed = amountUsed;
  }


  public double getAmountFrozen() {
    return amountFrozen;
  }

  public void setAmountFrozen(double amountFrozen) {
    this.amountFrozen = amountFrozen;
  }


  public double getDailyLimit() {
    return dailyLimit;
  }

  public void setDailyLimit(double dailyLimit) {
    this.dailyLimit = dailyLimit;
  }


  public double getMonthLimit() {
    return monthLimit;
  }

  public void setMonthLimit(double monthLimit) {
    this.monthLimit = monthLimit;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public Integer getActive() {
    return active;
  }

  public void setActive(Integer active) {
    this.active = active;
  }


  public Integer getDeleted() {
    return deleted;
  }

  public void setDeleted(Integer deleted) {
    this.deleted = deleted;
  }


  public Integer getGrantFrequency() {
    return grantFrequency;
  }

  public void setGrantFrequency(Integer grantFrequency) {
    this.grantFrequency = grantFrequency;
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
