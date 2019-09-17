package com.example.model;

public class User {

  private Integer id;
  private String mobile;
  private String ukKey;
  private String instId;
  private String instUserId;
  private String password;
  private String name;
  private String idNumber;
  private String gender;
  private String birthday;
  private String type;
  private String state;
  private Integer active;
  private Integer deleted;
  private java.sql.Date loginTime;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", mobile='" + mobile + '\'' +
            ", ukKey='" + ukKey + '\'' +
            ", instId='" + instId + '\'' +
            ", instUserId='" + instUserId + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", idNumber='" + idNumber + '\'' +
            ", gender='" + gender + '\'' +
            ", birthday='" + birthday + '\'' +
            ", type='" + type + '\'' +
            ", state='" + state + '\'' +
            ", active=" + active +
            ", deleted=" + deleted +
            ", loginTime=" + loginTime +
            ", gmtCreate=" + gmtCreate +
            ", gmtUpdate=" + gmtUpdate +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getUkKey() {
    return ukKey;
  }

  public void setUkKey(String ukKey) {
    this.ukKey = ukKey;
  }


  public String getInstId() {
    return instId;
  }

  public void setInstId(String instId) {
    this.instId = instId;
  }


  public String getInstUserId() {
    return instUserId;
  }

  public void setInstUserId(String instUserId) {
    this.instUserId = instUserId;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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


  public java.sql.Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(java.sql.Date loginTime) {
    this.loginTime = loginTime;
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
