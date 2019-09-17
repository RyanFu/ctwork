package com.example.model;

public class CronJobRecord {

  private Integer id;
  private String dayTime;
  private String state;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getDayTime() {
    return dayTime;
  }

  public void setDayTime(String dayTime) {
    this.dayTime = dayTime;
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
