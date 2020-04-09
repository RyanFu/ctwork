package com.example.model;

public class ChannelOcrInfoWithBLOBs extends ChannelOcrInfo {
    private String address;

    private String detail;

    public ChannelOcrInfoWithBLOBs(Long id, String uid, String name, String cardIdNo, String cardInvalidDate, String fetchPhotoMethod, String address, String detail) {
        super(id, uid, name, cardIdNo, cardInvalidDate, fetchPhotoMethod);
        this.address = address;
        this.detail = detail;
    }

    public ChannelOcrInfoWithBLOBs() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}