package net.one97.paytm.common.entity.upgradeKyc;

import net.one97.paytm.common.entity.IJRDataModel;

public class EkycData implements IJRDataModel {
    private String City;
    private String House;
    private String Imei;
    private String Latitude;
    private String Locality;
    private String Longitude;
    private String Make;
    private String Model;
    private String Pincode;
    private String Profession;
    private String State;
    private String addressType;
    private int agriIncome;
    private String annualIncome;
    private String appVersion;
    private String deviceId;
    private boolean fatcaDeclaration;
    private String fatherFirstName;
    private String fatherLastName;
    private boolean isCorrespondanceAddressSameAsAadhar;
    private boolean isFather;
    private String maritalStatus;
    private String motherFirstName;
    private String motherLastName;
    private int nonAgriIncome;
    private String osType;
    private String osVersion;
    private String panAckDate;
    private String panAckNumber;
    private String panNumber;
    private String streetName;
    private String subProfession;

    public boolean isCorrespondanceAddressSameAsAadhar() {
        return this.isCorrespondanceAddressSameAsAadhar;
    }

    public void setCorrespondanceAddressSameAsAadhar(boolean z) {
        this.isCorrespondanceAddressSameAsAadhar = z;
    }

    public boolean isFather() {
        return this.isFather;
    }

    public void setFather(boolean z) {
        this.isFather = z;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(String str) {
        this.maritalStatus = str;
    }

    public String getProfession() {
        return this.Profession;
    }

    public void setProfession(String str) {
        this.Profession = str;
    }

    public String getFatherFirstName() {
        return this.fatherFirstName;
    }

    public void setFatherFirstName(String str) {
        this.fatherFirstName = str;
    }

    public String getFatherLastName() {
        return this.fatherLastName;
    }

    public void setFatherLastName(String str) {
        this.fatherLastName = str;
    }

    public String getMotherFirstName() {
        return this.motherFirstName;
    }

    public void setMotherFirstName(String str) {
        this.motherFirstName = str;
    }

    public String getMotherLastName() {
        return this.motherLastName;
    }

    public void setMotherLastName(String str) {
        this.motherLastName = str;
    }

    public String getHouse() {
        return this.House;
    }

    public void setHouse(String str) {
        this.House = str;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String str) {
        this.streetName = str;
    }

    public String getLocality() {
        return this.Locality;
    }

    public void setLocality(String str) {
        this.Locality = str;
    }

    public String getPincode() {
        return this.Pincode;
    }

    public void setPincode(String str) {
        this.Pincode = str;
    }

    public String getState() {
        return this.State;
    }

    public void setState(String str) {
        this.State = str;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String str) {
        this.City = str;
    }

    public String getAddressType() {
        return this.addressType;
    }

    public void setAddressType(String str) {
        this.addressType = str;
    }

    public boolean isFatcaDeclaration() {
        return this.fatcaDeclaration;
    }

    public void setFatcaDeclaration(boolean z) {
        this.fatcaDeclaration = z;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getMake() {
        return this.Make;
    }

    public void setMake(String str) {
        this.Make = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getImei() {
        return this.Imei;
    }

    public void setImei(String str) {
        this.Imei = str;
    }

    public String getModel() {
        return this.Model;
    }

    public void setModel(String str) {
        this.Model = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(String str) {
        this.Latitude = str;
    }

    public String getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(String str) {
        this.Longitude = str;
    }

    public String getOsType() {
        return this.osType;
    }

    public void setOsType(String str) {
        this.osType = str;
    }

    public String getPanNumber() {
        return this.panNumber;
    }

    public void setPanNumber(String str) {
        this.panNumber = str;
    }

    public double getAgriIncome() {
        return (double) this.agriIncome;
    }

    public void setAgriIncome(int i2) {
        this.agriIncome = i2;
    }

    public double getNonAgriIncome() {
        return (double) this.nonAgriIncome;
    }

    public void setNonAgriIncome(int i2) {
        this.nonAgriIncome = i2;
    }

    public String getPanAckNumber() {
        return this.panAckNumber;
    }

    public void setPanAckNumber(String str) {
        this.panAckNumber = str;
    }

    public String getPanAckDate() {
        return this.panAckDate;
    }

    public void setPanAckDate(String str) {
        this.panAckDate = str;
    }

    public String getSubProfession() {
        return this.subProfession;
    }

    public void setSubProfession(String str) {
        this.subProfession = str;
    }

    public String getAnnualIncome() {
        return this.annualIncome;
    }

    public void setAnnualIncome(String str) {
        this.annualIncome = str;
    }
}
