package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class TollTagResponseEntryModel extends IJRDataModel {
    private int enableToggle;
    private String epcId;
    private String exceptionCode;
    private String imageUrl;
    private String statusInfo;
    private String tagBarCode;
    private String tagId;
    private String tagStatus;
    private int tagStatusCode;
    private int toggleState;
    private String vehicleClass;
    private int vehicleClassCode;
    private String vehicleRegistrationNo;

    public String getTagId() {
        return this.tagId;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }

    public String getExceptionCode() {
        return this.exceptionCode;
    }

    public void setExceptionCode(String str) {
        this.exceptionCode = str;
    }

    public String getVehicleRegistrationNo() {
        return this.vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String str) {
        this.vehicleRegistrationNo = str;
    }

    public String getVehicleClass() {
        return this.vehicleClass;
    }

    public void setVehicleClass(String str) {
        this.vehicleClass = str;
    }

    public String getTagBarCode() {
        return this.tagBarCode;
    }

    public void setTagBarCode(String str) {
        this.tagBarCode = str;
    }

    public String getTagStatus() {
        return this.tagStatus;
    }

    public void setTagStatus(String str) {
        this.tagStatus = str;
    }

    public int getTagStatusCode() {
        return this.tagStatusCode;
    }

    public void setTagStatusCode(int i2) {
        this.tagStatusCode = i2;
    }

    public int getVehicleClassCode() {
        return this.vehicleClassCode;
    }

    public void setVehicleClassCode(int i2) {
        this.vehicleClassCode = i2;
    }

    public String getEpcId() {
        return this.epcId;
    }

    public void setEpcId(String str) {
        this.epcId = str;
    }

    public String getStatusInfo() {
        return this.statusInfo;
    }

    public void setStatusInfo(String str) {
        this.statusInfo = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public int getEnableToggle() {
        return this.enableToggle;
    }

    public void setEnableToggle(int i2) {
        this.enableToggle = i2;
    }

    public int getToggleState() {
        return this.toggleState;
    }

    public void setToggleState(int i2) {
        this.toggleState = i2;
    }
}
