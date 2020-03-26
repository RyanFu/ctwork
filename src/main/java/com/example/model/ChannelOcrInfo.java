package com.example.model;

public class ChannelOcrInfo {
    private Long id;

    private String uid;

    private String name;

    private String cardIdNo;

    private String cardInvalidDate;

    private String fetchPhotoMethod;

    public ChannelOcrInfo(Long id, String uid, String name, String cardIdNo, String cardInvalidDate, String fetchPhotoMethod) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.cardIdNo = cardIdNo;
        this.cardInvalidDate = cardInvalidDate;
        this.fetchPhotoMethod = fetchPhotoMethod;
    }

    public ChannelOcrInfo() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCardIdNo() {
        return cardIdNo;
    }

    public void setCardIdNo(String cardIdNo) {
        this.cardIdNo = cardIdNo == null ? null : cardIdNo.trim();
    }

    public String getCardInvalidDate() {
        return cardInvalidDate;
    }

    public void setCardInvalidDate(String cardInvalidDate) {
        this.cardInvalidDate = cardInvalidDate == null ? null : cardInvalidDate.trim();
    }

    public String getFetchPhotoMethod() {
        return fetchPhotoMethod;
    }

    public void setFetchPhotoMethod(String fetchPhotoMethod) {
        this.fetchPhotoMethod = fetchPhotoMethod == null ? null : fetchPhotoMethod.trim();
    }
}