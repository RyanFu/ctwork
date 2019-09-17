package com.example.model;

public class RightRule {

  private Integer id;
  private String ruleName;
  private String type;
  private String ruleCondition;
  private String conditionVersion;
  private String ruleDetail;
  private String detailVersion;
  private Integer deleted;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getRuleCondition() {
    return ruleCondition;
  }

  public void setRuleCondition(String ruleCondition) {
    this.ruleCondition = ruleCondition;
  }


  public String getConditionVersion() {
    return conditionVersion;
  }

  public void setConditionVersion(String conditionVersion) {
    this.conditionVersion = conditionVersion;
  }


  public String getRuleDetail() {
    return ruleDetail;
  }

  public void setRuleDetail(String ruleDetail) {
    this.ruleDetail = ruleDetail;
  }


  public String getDetailVersion() {
    return detailVersion;
  }

  public void setDetailVersion(String detailVersion) {
    this.detailVersion = detailVersion;
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
