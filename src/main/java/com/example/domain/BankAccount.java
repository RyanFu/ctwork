package com.example.domain;


import lombok.Data;

@Data
public class BankAccount {

  private Integer id;
  private Integer applyId;
  private String businessName;
  private String openId;
  private String accountNo;
  private String accountLevel;
  private String accountPayType;
  private String accountBankCode;
  private String name;
  private String idNumber;
  private String bindingCardNo;
  private String bindingCardMobile;
  private String bindingCardBank;
  private String extFields;
  private String state;
  private Integer deleted;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getApplyId() {
    return applyId;
  }

  public void setApplyId(Integer applyId) {
    this.applyId = applyId;
  }


  public String getBusinessName() {
    return businessName;
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }


  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }


  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }


  public String getAccountLevel() {
    return accountLevel;
  }

  public void setAccountLevel(String accountLevel) {
    this.accountLevel = accountLevel;
  }


  public String getAccountPayType() {
    return accountPayType;
  }

  public void setAccountPayType(String accountPayType) {
    this.accountPayType = accountPayType;
  }


  public String getAccountBankCode() {
    return accountBankCode;
  }

  public void setAccountBankCode(String accountBankCode) {
    this.accountBankCode = accountBankCode;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }


  public String getBindingCardNo() {
    return bindingCardNo;
  }

  public void setBindingCardNo(String bindingCardNo) {
    this.bindingCardNo = bindingCardNo;
  }


  public String getBindingCardMobile() {
    return bindingCardMobile;
  }

  public void setBindingCardMobile(String bindingCardMobile) {
    this.bindingCardMobile = bindingCardMobile;
  }


  public String getBindingCardBank() {
    return bindingCardBank;
  }

  public void setBindingCardBank(String bindingCardBank) {
    this.bindingCardBank = bindingCardBank;
  }


  public String getExtFields() {
    return extFields;
  }

  public void setExtFields(String extFields) {
    this.extFields = extFields;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
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
