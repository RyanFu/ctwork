package com.example.model;

public class UserRebate {

  private Integer id;
  private Integer userId;
  private double dailyLimit;
  private double monthLimit;
  private double available;
  private double total;
  private Integer countTotal;
  private double used;
  private Integer countUsed;
  private Integer active;
  private Integer deleted;
  private java.sql.Date statisticTime;
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


  public double getAvailable() {
    return available;
  }

  public void setAvailable(double available) {
    this.available = available;
  }


  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }


  public Integer getCountTotal() {
    return countTotal;
  }

  public void setCountTotal(Integer countTotal) {
    this.countTotal = countTotal;
  }


  public double getUsed() {
    return used;
  }

  public void setUsed(double used) {
    this.used = used;
  }


  public Integer getCountUsed() {
    return countUsed;
  }

  public void setCountUsed(Integer countUsed) {
    this.countUsed = countUsed;
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


  public java.sql.Date getStatisticTime() {
    return statisticTime;
  }

  public void setStatisticTime(java.sql.Date statisticTime) {
    this.statisticTime = statisticTime;
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
