package com.example.model;

public class RiskControlRecord {

  private Integer id;
  private Integer riskId;
  private String req;
  private String resp;
  private java.sql.Date gmtCreate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getRiskId() {
    return riskId;
  }

  public void setRiskId(Integer riskId) {
    this.riskId = riskId;
  }


  public String getReq() {
    return req;
  }

  public void setReq(String req) {
    this.req = req;
  }


  public String getResp() {
    return resp;
  }

  public void setResp(String resp) {
    this.resp = resp;
  }


  public java.sql.Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(java.sql.Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

}
