package com.example.model.cmp;

public class TrafficUser {
    private Long id;

    private Long trafficId;

    private String externalId;

    private String idType;

    private String idNumber;

    private String name;

    private String mobileNumber;

    private String gender;

    private String tags;

    private Long createAt;

    private Long updateAt;

    private String extra;

    public TrafficUser(Long id, Long trafficId, String externalId, String idType, String idNumber, String name, String mobileNumber, String gender, String tags, Long createAt, Long updateAt, String extra) {
        this.id = id;
        this.trafficId = trafficId;
        this.externalId = externalId;
        this.idType = idType;
        this.idNumber = idNumber;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.tags = tags;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "TrafficUser{" +
                "id=" + id +
                ", trafficId=" + trafficId +
                ", externalId='" + externalId + '\'' +
                ", idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", tags='" + tags + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", extra='" + extra + '\'' +
                '}';
    }

    public TrafficUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(Long trafficId) {
        this.trafficId = trafficId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId == null ? null : externalId.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra == null ? null : extra.trim();
    }
}