package net.one97.paytm.common.entity.RiskAnalysis;

import java.util.ArrayList;

public class RiskExtendedInfo {
    private String CHANNEL_ID;
    private String IMEI;
    private String appVersion;
    private String channelId;
    private String clientIp;
    private String contactCreateTime;
    private ArrayList<DeviceAccount> deviceAccounts;
    private String deviceId;
    private String deviceLanguage;
    private String deviceManufacturer;
    private String displayName;
    private String fuzzyDeviceId;
    private boolean isContact;
    private boolean isGalleryScan;
    private boolean isOfflineMerchant;
    private boolean isOnlineMerchant;
    private boolean isRooted;
    private ArrayList<String> lci;
    private ArrayList<Boolean> lcic;
    private ArrayList<String> lco;
    private String mode;
    private String operationOrigin;
    private String operationType;
    private String osType;
    private boolean otpReadFlag;
    private String paymentFlow;
    private String phoneModel;
    private String productCode;
    private String requestType;
    private String routerMac;
    private String scanType;
    private String screenResolution;
    private String terminalType;
    private String timeZone;
    private String transactionType;
    private String userLBSLatitude;
    private String userLBSLongitude;
    private String versionCode;
    private ArrayList<String> wifissid;

    public ArrayList<DeviceAccount> getDeviceAccounts() {
        return this.deviceAccounts;
    }

    public RiskExtendedInfo setDeviceAccounts(ArrayList<DeviceAccount> arrayList) {
        this.deviceAccounts = arrayList;
        return this;
    }

    public String getContactCreateTime() {
        return this.contactCreateTime;
    }

    public RiskExtendedInfo setContactCreateTime(String str) {
        this.contactCreateTime = str;
        return this;
    }

    public String getWifissid() {
        ArrayList<String> arrayList = this.wifissid;
        return (arrayList == null || arrayList.size() <= 0) ? "" : this.wifissid.get(0);
    }

    public RiskExtendedInfo setWifissid(ArrayList<String> arrayList) {
        this.wifissid = arrayList;
        return this;
    }

    public boolean getIsContact() {
        return this.isContact;
    }

    public RiskExtendedInfo setIsContact(boolean z) {
        this.isContact = z;
        return this;
    }

    public boolean getOtpReadFlag() {
        return this.otpReadFlag;
    }

    public RiskExtendedInfo setOtpReadFlag(boolean z) {
        this.otpReadFlag = z;
        return this;
    }

    public boolean getIsRooted() {
        return this.isRooted;
    }

    public RiskExtendedInfo setIsRooted(boolean z) {
        this.isRooted = z;
        return this;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public RiskExtendedInfo setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public String getScanType() {
        return this.scanType;
    }

    public RiskExtendedInfo setScanType(String str) {
        this.scanType = str;
        return this;
    }

    public String getMode() {
        return this.mode;
    }

    public RiskExtendedInfo setMode(String str) {
        this.mode = str;
        return this;
    }

    public void setLci(ArrayList<String> arrayList) {
        this.lci = arrayList;
    }

    public void setLco(ArrayList<String> arrayList) {
        this.lco = arrayList;
    }

    public RiskExtendedInfo setLatitude(String str) {
        this.userLBSLatitude = str;
        return this;
    }

    public String getUserLbsLatitude() {
        return this.userLBSLatitude;
    }

    public String getUserLbsLongitude() {
        return this.userLBSLongitude;
    }

    public RiskExtendedInfo setLongitude(String str) {
        this.userLBSLongitude = str;
        return this;
    }

    public void setTranscationType(String str) {
        this.transactionType = str;
    }

    public void setIncomingCall(String str) {
        if (this.lci == null) {
            this.lci = new ArrayList<>();
        }
        if (!this.lci.contains(str)) {
            if (this.lci.size() >= 3) {
                this.lci.remove(0);
            }
            this.lci.add(0, str);
        }
    }

    public void setOutgoingCall(String str) {
        if (this.lco == null) {
            this.lco = new ArrayList<>();
        }
        if (!this.lco.contains(str)) {
            if (this.lco.size() >= 3) {
                this.lco.remove(0);
            }
            this.lco.add(0, str);
        }
    }

    public ArrayList<String> getLci() {
        return this.lci;
    }

    public ArrayList<String> getLco() {
        return this.lco;
    }

    public ArrayList<Boolean> getLcic() {
        return this.lcic;
    }

    public RiskExtendedInfo setLcic(ArrayList<Boolean> arrayList) {
        this.lcic = arrayList;
        return this;
    }

    public String getWifi() {
        ArrayList<String> arrayList = this.wifissid;
        return (arrayList == null || arrayList.size() <= 0) ? "" : this.wifissid.get(0);
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public RiskExtendedInfo setTransactionType(String str) {
        this.transactionType = str;
        return this;
    }

    public RiskExtendedInfo setChannelID(String str) {
        this.channelId = str;
        return this;
    }

    public String getChannelID() {
        return this.channelId;
    }

    public RiskExtendedInfo setChannelIDV2(String str) {
        this.CHANNEL_ID = str;
        return this;
    }

    public String getChannelIDV2() {
        return this.CHANNEL_ID;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public RiskExtendedInfo setTerminalType(String str) {
        this.terminalType = str;
        return this;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public RiskExtendedInfo setDeviceId(String str) {
        this.deviceId = str;
        return this;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public RiskExtendedInfo setAppVersion(String str) {
        this.appVersion = str;
        return this;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public RiskExtendedInfo setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    public String getOsType() {
        return this.osType;
    }

    public RiskExtendedInfo setOsType(String str) {
        this.osType = str;
        return this;
    }

    public String getScreenResolution() {
        return this.screenResolution;
    }

    public RiskExtendedInfo setScreenResolution(String str) {
        this.screenResolution = str;
        return this;
    }

    public String getPhoneModel() {
        return this.phoneModel;
    }

    public RiskExtendedInfo setPhoneModel(String str) {
        this.phoneModel = str;
        return this;
    }

    public String getIMEI() {
        return this.IMEI;
    }

    public RiskExtendedInfo setIMEI(String str) {
        this.IMEI = str;
        return this;
    }

    public String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    public RiskExtendedInfo setDeviceManufacturer(String str) {
        this.deviceManufacturer = str;
        return this;
    }

    public String getDeviceLanguage() {
        return this.deviceLanguage;
    }

    public RiskExtendedInfo setDeviceLanguage(String str) {
        this.deviceLanguage = str;
        return this;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public RiskExtendedInfo setTimeZone(String str) {
        this.timeZone = str;
        return this;
    }

    public String getRouterMac() {
        return this.routerMac;
    }

    public RiskExtendedInfo setRouterMac(String str) {
        this.routerMac = str;
        return this;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public RiskExtendedInfo setClientIp(String str) {
        this.clientIp = str;
        return this;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public RiskExtendedInfo setProductCode(String str) {
        this.productCode = str;
        return this;
    }

    public boolean isGalleryScan() {
        return this.isGalleryScan;
    }

    public boolean getIsOfflineMerchant() {
        return this.isOfflineMerchant;
    }

    public RiskExtendedInfo setIsOfflineMerchant(boolean z) {
        this.isOfflineMerchant = z;
        return this;
    }

    public boolean getIsOnlineMerchant() {
        return this.isOnlineMerchant;
    }

    public RiskExtendedInfo setIsOnlineMerchant(boolean z) {
        this.isOnlineMerchant = z;
        return this;
    }

    public String getOperationOrigin() {
        return this.operationOrigin;
    }

    public RiskExtendedInfo setOperationOrigin(String str) {
        this.operationOrigin = str;
        return this;
    }

    public String getPaymentFlow() {
        return this.paymentFlow;
    }

    public RiskExtendedInfo setPaymentFlow(String str) {
        this.paymentFlow = str;
        return this;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public RiskExtendedInfo setOperationType(String str) {
        this.operationType = str;
        return this;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public RiskExtendedInfo setRequestType(String str) {
        this.requestType = str;
        return this;
    }

    public String getFuzzyDeviceId() {
        return this.fuzzyDeviceId;
    }

    public RiskExtendedInfo setFuzzyDeviceId(String str) {
        this.fuzzyDeviceId = str;
        return this;
    }

    public RiskExtendedInfo setGalleryScan(boolean z) {
        this.isGalleryScan = z;
        return this;
    }
}
