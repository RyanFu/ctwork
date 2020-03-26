package com.example.model;

public class ChannelRelationInfo {
    private Long id;

    private String uid;

    private Integer relationLevel;

    private String relationName;

    private String mobileNo;

    private String relation;

    public ChannelRelationInfo(Long id, String uid, Integer relationLevel, String relationName, String mobileNo, String relation) {
        this.id = id;
        this.uid = uid;
        this.relationLevel = relationLevel;
        this.relationName = relationName;
        this.mobileNo = mobileNo;
        this.relation = relation;
    }

    public ChannelRelationInfo() {
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

    public Integer getRelationLevel() {
        return relationLevel;
    }

    public void setRelationLevel(Integer relationLevel) {
        this.relationLevel = relationLevel;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName == null ? null : relationName.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }
}