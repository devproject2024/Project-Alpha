package net.one97.paytm.nativesdk.common.model;

public class RiskExtendedInfo {
    private String contactCreateTime;
    private String deviceAccounts;
    private String displayName;
    private String isContact;
    private String isRooted;
    private String[] lastCallContacts;
    private String mode;
    private String otpReadFlag;
    private String scanType;
    private String[] wifissid;

    public String getDeviceAccounts() {
        return this.deviceAccounts;
    }

    public void setDeviceAccounts(String str) {
        this.deviceAccounts = str;
    }

    public String getContactCreateTime() {
        return this.contactCreateTime;
    }

    public void setContactCreateTime(String str) {
        this.contactCreateTime = str;
    }

    public String[] getWifissid() {
        return this.wifissid;
    }

    public void setWifissid(String[] strArr) {
        this.wifissid = strArr;
    }

    public String getIsContact() {
        return this.isContact;
    }

    public void setIsContact(String str) {
        this.isContact = str;
    }

    public String getOtpReadFlag() {
        return this.otpReadFlag;
    }

    public void setOtpReadFlag(String str) {
        this.otpReadFlag = str;
    }

    public String getIsRooted() {
        return this.isRooted;
    }

    public void setIsRooted(String str) {
        this.isRooted = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getScanType() {
        return this.scanType;
    }

    public void setScanType(String str) {
        this.scanType = str;
    }

    public String[] getLastCallContacts() {
        return this.lastCallContacts;
    }

    public void setLastCallContacts(String[] strArr) {
        this.lastCallContacts = strArr;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public String toString() {
        return "ClassPojo [deviceAccounts = " + this.deviceAccounts + ", contactCreateTime = " + this.contactCreateTime + ", wifissid = " + this.wifissid + ", isContact = " + this.isContact + ", otpReadFlag = " + this.otpReadFlag + ", isRooted = " + this.isRooted + ", displayName = " + this.displayName + ", scanType = " + this.scanType + ", lastCallContacts = " + this.lastCallContacts + ", mode = " + this.mode + "]";
    }
}
