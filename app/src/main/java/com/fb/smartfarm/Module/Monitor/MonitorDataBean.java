package com.fb.smartfarm.Module.Monitor;

/**
 * Created by echo on 2017/6/1.
 */


public class MonitorDataBean {
    private String co2Concentration = "";
    private String userIdUpdate = "";
    private String agrTerminalId = "";
    private String airTemp = "";
    private String updateTime = "";
    private String soilHumidity = "";
    private String userIdCreate = "";
    private String mac = "";
    private String lux = "";
    private String soilTemp = "";
    private String deleted = "";
    private String createTime = "";
    private String airHumidity = "";
    private String id = "";
    private String status = "";

    public String getCo2Concentration() {
        return co2Concentration;
    }

    public String getUserIdUpdate() {
        return userIdUpdate;
    }

    public String getAgrTerminalId() {
        return agrTerminalId;
    }

    public String getAirTemp() {
        return airTemp;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getSoilHumidity() {
        return soilHumidity;
    }

    public String getUserIdCreate() {
        return userIdCreate;
    }

    public String getMac() {
        return mac;
    }

    public String getLux() {
        return lux;
    }

    public String getSoilTemp() {
        return soilTemp;
    }

    public String getDeleted() {
        return deleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getAirHumidity() {
        return airHumidity;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setCo2Concentration(String co2Concentration) {
        this.co2Concentration = co2Concentration;
    }

    public void setUserIdUpdate(String userIdUpdate) {
        this.userIdUpdate = userIdUpdate;
    }

    public void setAgrTerminalId(String agrTerminalId) {
        this.agrTerminalId = agrTerminalId;
    }

    public void setAirTemp(String airTemp) {
        this.airTemp = airTemp;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setSoilHumidity(String soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public void setUserIdCreate(String userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setLux(String lux) {
        this.lux = lux;
    }

    public void setSoilTemp(String soilTemp) {
        this.soilTemp = soilTemp;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setAirHumidity(String airHumidity) {
        this.airHumidity = airHumidity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MonitorBean{" +
                "co2Concentration='" + co2Concentration + '\'' +
                ", userIdUpdate='" + userIdUpdate + '\'' +
                ", agrTerminalId='" + agrTerminalId + '\'' +
                ", airTemp='" + airTemp + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", soilHumidity='" + soilHumidity + '\'' +
                ", userIdCreate='" + userIdCreate + '\'' +
                ", mac='" + mac + '\'' +
                ", lux='" + lux + '\'' +
                ", soilTemp='" + soilTemp + '\'' +
                ", deleted='" + deleted + '\'' +
                ", createTime='" + createTime + '\'' +
                ", airHumidity='" + airHumidity + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

