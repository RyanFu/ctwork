package com.example.domain;


public class TradeRequestLog {

  private Integer id;
  private String cardNo;
  private String serialNo;
  private String transType;
  private String orderNo;
  private String serverName;
  private String channel;
  private String url;
  private String state;
  private String dataReq;
  private String dataResp;
  private String originReq;
  private String originResp;
  private java.sql.Date gmtCreate;
  private java.sql.Date gmtUpdate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getCardNo() {
    return cardNo;
  }

  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
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


  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }


  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }


  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getDataReq() {
    return dataReq;
  }

  public void setDataReq(String dataReq) {
    this.dataReq = dataReq;
  }


  public String getDataResp() {
    return dataResp;
  }

  public void setDataResp(String dataResp) {
    this.dataResp = dataResp;
  }


  public String getOriginReq() {
    return originReq;
  }

  public void setOriginReq(String originReq) {
    this.originReq = originReq;
  }


  public String getOriginResp() {
    return originResp;
  }

  public void setOriginResp(String originResp) {
    this.originResp = originResp;
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
