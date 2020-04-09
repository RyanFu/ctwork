package com.example.model;

public class ChannelBankInfo {
    private Long id;

    private String uid;

    private String bankCardNo;

    private String productCd;

    private String mobile;

    private String cardName;

    private String cardType;

    private String bankName;

    private String bankShortCd;

    private String cardBinNo;

    private Integer cardLength;

    private String bankNo;

    private String acctFunctionType;

    public ChannelBankInfo(Long id, String uid, String bankCardNo, String productCd, String mobile, String cardName, String cardType, String bankName, String bankShortCd, String cardBinNo, Integer cardLength, String bankNo, String acctFunctionType) {
        this.id = id;
        this.uid = uid;
        this.bankCardNo = bankCardNo;
        this.productCd = productCd;
        this.mobile = mobile;
        this.cardName = cardName;
        this.cardType = cardType;
        this.bankName = bankName;
        this.bankShortCd = bankShortCd;
        this.cardBinNo = cardBinNo;
        this.cardLength = cardLength;
        this.bankNo = bankNo;
        this.acctFunctionType = acctFunctionType;
    }

    public ChannelBankInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd == null ? null : productCd.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankShortCd() {
        return bankShortCd;
    }

    public void setBankShortCd(String bankShortCd) {
        this.bankShortCd = bankShortCd == null ? null : bankShortCd.trim();
    }

    public String getCardBinNo() {
        return cardBinNo;
    }

    public void setCardBinNo(String cardBinNo) {
        this.cardBinNo = cardBinNo == null ? null : cardBinNo.trim();
    }

    public Integer getCardLength() {
        return cardLength;
    }

    public void setCardLength(Integer cardLength) {
        this.cardLength = cardLength;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getAcctFunctionType() {
        return acctFunctionType;
    }

    public void setAcctFunctionType(String acctFunctionType) {
        this.acctFunctionType = acctFunctionType == null ? null : acctFunctionType.trim();
    }
}