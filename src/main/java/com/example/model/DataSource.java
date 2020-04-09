package com.example.model;


public class DataSource {
    private Long id;

    private String name;

    private String enName;

    private String description;

    private Boolean isPublic;

    private String callType;

    private String urlPattern;

    private String createBy;

    private String updateBy;

    private Long createAt;

    private Long updateAt;

    private Integer timeout;

    private Long dataSourceAuthId;

    public DataSource(Long id, String name, String enName, String description, Boolean isPublic, String callType, String urlPattern, String createBy, String updateBy, Long createAt, Long updateAt, Integer timeout, Long dataSourceAuthId) {
        this.id = id;
        this.name = name;
        this.enName = enName;
        this.description = description;
        this.isPublic = isPublic;
        this.callType = callType;
        this.urlPattern = urlPattern;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.timeout = timeout;
        this.dataSourceAuthId = dataSourceAuthId;
    }

    public DataSource() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern == null ? null : urlPattern.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Long getDataSourceAuthId() {
        return dataSourceAuthId;
    }

    public void setDataSourceAuthId(Long dataSourceAuthId) {
        this.dataSourceAuthId = dataSourceAuthId;
    }


    @Override
    public String toString() {
        return "DataSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enName='" + enName + '\'' +
                ", description='" + description + '\'' +
                ", isPublic=" + isPublic +
                ", callType='" + callType + '\'' +
                ", urlPattern='" + urlPattern + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", timeout=" + timeout +
                ", dataSourceAuthId=" + dataSourceAuthId +
                '}';
    }
}