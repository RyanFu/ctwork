package com.example.model;

import java.util.Date;

public class ChannelFaceResultInfo {
    private Long id;

    private String uid;

    private String threshold;

    private String faceCmpScore;

    private String faceAuthTimes;

    private String aliveTimes;

    private String detail;

    private Date applyDate;

    private Integer version;

    public ChannelFaceResultInfo(Long id, String uid, String threshold, String faceCmpScore, String faceAuthTimes, String aliveTimes, String detail, Date applyDate, Integer version) {
        this.id = id;
        this.uid = uid;
        this.threshold = threshold;
        this.faceCmpScore = faceCmpScore;
        this.faceAuthTimes = faceAuthTimes;
        this.aliveTimes = aliveTimes;
        this.detail = detail;
        this.applyDate = applyDate;
        this.version = version;
    }

    public ChannelFaceResultInfo() {
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

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold == null ? null : threshold.trim();
    }

    public String getFaceCmpScore() {
        return faceCmpScore;
    }

    public void setFaceCmpScore(String faceCmpScore) {
        this.faceCmpScore = faceCmpScore == null ? null : faceCmpScore.trim();
    }

    public String getFaceAuthTimes() {
        return faceAuthTimes;
    }

    public void setFaceAuthTimes(String faceAuthTimes) {
        this.faceAuthTimes = faceAuthTimes == null ? null : faceAuthTimes.trim();
    }

    public String getAliveTimes() {
        return aliveTimes;
    }

    public void setAliveTimes(String aliveTimes) {
        this.aliveTimes = aliveTimes == null ? null : aliveTimes.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}