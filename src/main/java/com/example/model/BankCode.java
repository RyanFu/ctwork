package com.example.model;

public class BankCode {

  private Integer id;
  private String bankCode;
  private String bankName;
  private String thirdAuthIssue;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }


  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }


  public String getThirdAuthIssue() {
    return thirdAuthIssue;
  }

  public void setThirdAuthIssue(String thirdAuthIssue) {
    this.thirdAuthIssue = thirdAuthIssue;
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
