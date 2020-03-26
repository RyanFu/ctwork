package com.example.model;

import java.util.Date;

public class ChannelUserInfo {
    private Long id;

    private String uid;

    private String idCardNo;

    private String mobileNo;

    private String userName;

    private Integer age;

    private String gender;

    private String cardInvalidDate;

    private String eduType;

    private String nationality;

    private String monthlyWages;

    private String occupation;

    private String email;

    private String companyName;

    private String companyAddress;

    private String permanentAddress;

    private String province;

    private String city;

    private String area;

    private String provinceCode;

    private String cityCode;

    private String areaCode;

    private String trafficCode;

    private String productCode;

    private Integer node;

    private Date applyDate;

    private Integer version;

    public ChannelUserInfo(Long id, String uid, String idCardNo, String mobileNo, String userName, Integer age, String gender, String cardInvalidDate, String eduType, String nationality, String monthlyWages, String occupation, String email, String companyName, String companyAddress, String permanentAddress, String province, String city, String area, String provinceCode, String cityCode, String areaCode, String trafficCode, String productCode, Integer node, Date applyDate, Integer version) {
        this.id = id;
        this.uid = uid;
        this.idCardNo = idCardNo;
        this.mobileNo = mobileNo;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.cardInvalidDate = cardInvalidDate;
        this.eduType = eduType;
        this.nationality = nationality;
        this.monthlyWages = monthlyWages;
        this.occupation = occupation;
        this.email = email;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.permanentAddress = permanentAddress;
        this.province = province;
        this.city = city;
        this.area = area;
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.areaCode = areaCode;
        this.trafficCode = trafficCode;
        this.productCode = productCode;
        this.node = node;
        this.applyDate = applyDate;
        this.version = version;
    }

    public ChannelUserInfo() {
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

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCardInvalidDate() {
        return cardInvalidDate;
    }

    public void setCardInvalidDate(String cardInvalidDate) {
        this.cardInvalidDate = cardInvalidDate == null ? null : cardInvalidDate.trim();
    }

    public String getEduType() {
        return eduType;
    }

    public void setEduType(String eduType) {
        this.eduType = eduType == null ? null : eduType.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getMonthlyWages() {
        return monthlyWages;
    }

    public void setMonthlyWages(String monthlyWages) {
        this.monthlyWages = monthlyWages == null ? null : monthlyWages.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress == null ? null : permanentAddress.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getTrafficCode() {
        return trafficCode;
    }

    public void setTrafficCode(String trafficCode) {
        this.trafficCode = trafficCode == null ? null : trafficCode.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
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