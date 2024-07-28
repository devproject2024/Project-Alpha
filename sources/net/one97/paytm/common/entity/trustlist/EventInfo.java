package net.one97.paytm.common.entity.trustlist;

public class EventInfo {
    private String appVersion;
    private String clientIp;
    private String clientKey;
    private String extendInfo;
    private String merchantAppVersion;
    private String orderOsType;
    private String orderTerminalType;
    private String osType;
    private String sdkVersion;
    private String sessionId;
    private String terminalType;
    private String tokenId;
    private String websiteLanguage;

    public String getWebsiteLanguage() {
        return this.websiteLanguage;
    }

    public void setWebsiteLanguage(String str) {
        this.websiteLanguage = str;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public void setTokenId(String str) {
        this.tokenId = str;
    }

    public String getMerchantAppVersion() {
        return this.merchantAppVersion;
    }

    public void setMerchantAppVersion(String str) {
        this.merchantAppVersion = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public void setClientKey(String str) {
        this.clientKey = str;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public String getOrderTerminalType() {
        return this.orderTerminalType;
    }

    public void setOrderTerminalType(String str) {
        this.orderTerminalType = str;
    }

    public String getOsType() {
        return this.osType;
    }

    public void setOsType(String str) {
        this.osType = str;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    public String getOrderOsType() {
        return this.orderOsType;
    }

    public void setOrderOsType(String str) {
        this.orderOsType = str;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }
}
