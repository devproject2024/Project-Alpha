package net.one97.paytm.common.entity.offline_pg;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPGTransactionParams implements IJRDataModel {
    private String LINK_DESCRIPTION;
    String authMode;
    String channelId;
    String currency;
    String id;
    String industryType;
    private boolean isBalanceUnavailable;
    private boolean isPCF;
    String linkType;
    private String mAdditionalInfo;
    private String mOrderId;
    String mPosId;
    String merchantGUID;
    String mid;
    String paymentMode;
    private Double pcfAmount;
    String qrCodeId;
    private String refId;
    String txnAmount;

    public String getAdditionalInfo() {
        return this.mAdditionalInfo;
    }

    public void setOrderId(String str) {
        this.mOrderId = str;
    }

    public String getPosId() {
        return this.mPosId;
    }

    public String getQrCodeId() {
        return this.qrCodeId;
    }

    public void setQrCodeId(String str) {
        this.qrCodeId = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getAuthMode() {
        return this.authMode;
    }

    public void setAuthMode(String str) {
        this.authMode = str;
    }

    public String getIndustryType() {
        return this.industryType;
    }

    public void setIndustryType(String str) {
        this.industryType = str;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(String str) {
        this.txnAmount = str;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getMerchantGUID() {
        return this.merchantGUID;
    }

    public void setMerchantGUID(String str) {
        this.merchantGUID = str;
    }

    public void setPosId(String str) {
        this.mPosId = str;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public void setAdditionalInfo(String str) {
        this.mAdditionalInfo = str;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setLinkType(String str) {
        this.linkType = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLinkDescription(String str) {
        this.LINK_DESCRIPTION = str;
    }

    public String getLinkDescription() {
        return this.LINK_DESCRIPTION;
    }

    public boolean isBalanceUnavailable() {
        return this.isBalanceUnavailable;
    }

    public void setBalanceUnavailable(boolean z) {
        this.isBalanceUnavailable = z;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String str) {
        this.refId = str;
    }

    public void setIsPcf(boolean z) {
        this.isPCF = z;
    }

    public void setPcfAmount(Double d2) {
        this.pcfAmount = d2;
    }

    public boolean isPCF() {
        return this.isPCF;
    }

    public Double getPcfAmount() {
        return this.pcfAmount;
    }
}
