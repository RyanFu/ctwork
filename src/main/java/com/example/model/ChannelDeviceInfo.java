package com.example.model;

import java.util.Date;

public class ChannelDeviceInfo {
    private Long id;

    private String uid;

    private String ip;

    private String imei;

    private String internetType;

    private String wifiId;

    private String wifiName;

    private Double latitude;

    private Double longitude;

    private String mac;

    private String phoneModel;

    private String phoneMarker;

    private String os;

    private String availableCapacity;

    private String memory;

    private String isRoot;

    private String resolution;

    private String trafficCode;

    private String productCode;

    private Integer node;

    private Date applyDate;

    private Integer version;

    public ChannelDeviceInfo(Long id, String uid, String ip, String imei, String internetType, String wifiId, String wifiName, Double latitude, Double longitude, String mac, String phoneModel, String phoneMarker, String os, String availableCapacity, String memory, String isRoot, String resolution, String trafficCode, String productCode, Integer node, Date applyDate, Integer version) {
        this.id = id;
        this.uid = uid;
        this.ip = ip;
        this.imei = imei;
        this.internetType = internetType;
        this.wifiId = wifiId;
        this.wifiName = wifiName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mac = mac;
        this.phoneModel = phoneModel;
        this.phoneMarker = phoneMarker;
        this.os = os;
        this.availableCapacity = availableCapacity;
        this.memory = memory;
        this.isRoot = isRoot;
        this.resolution = resolution;
        this.trafficCode = trafficCode;
        this.productCode = productCode;
        this.node = node;
        this.applyDate = applyDate;
        this.version = version;
    }

    public ChannelDeviceInfo() {
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public String getInternetType() {
        return internetType;
    }

    public void setInternetType(String internetType) {
        this.internetType = internetType == null ? null : internetType.trim();
    }

    public String getWifiId() {
        return wifiId;
    }

    public void setWifiId(String wifiId) {
        this.wifiId = wifiId == null ? null : wifiId.trim();
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName == null ? null : wifiName.trim();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel == null ? null : phoneModel.trim();
    }

    public String getPhoneMarker() {
        return phoneMarker;
    }

    public void setPhoneMarker(String phoneMarker) {
        this.phoneMarker = phoneMarker == null ? null : phoneMarker.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(String availableCapacity) {
        this.availableCapacity = availableCapacity == null ? null : availableCapacity.trim();
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory == null ? null : memory.trim();
    }

    public String getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(String isRoot) {
        this.isRoot = isRoot == null ? null : isRoot.trim();
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution == null ? null : resolution.trim();
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