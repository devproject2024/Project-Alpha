package net.one97.paytm.common.entity.wallet.postcard.data;

import java.math.BigDecimal;
import java.util.List;

public class CRJCreateLifafaReq {
    private String category;
    private String creatorId;
    private String creatorType;
    private String distributionType;
    private boolean gamify;
    private String merchantLogo;
    private String message;
    private BigDecimal minQuantity;
    private String name;
    private BigDecimal proposedQuantity;
    private int proposedReceiverCount;
    private List<String> recipientList;
    private String recipientListType;
    private boolean showOtherRecipients;
    private String strategyType;
    private String themeGuid;
    private String unit;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getStrategyType() {
        return this.strategyType;
    }

    public void setStrategyType(String str) {
        this.strategyType = str;
    }

    public String getDistributionType() {
        return this.distributionType;
    }

    public void setDistributionType(String str) {
        this.distributionType = str;
    }

    public int getProposedReceiverCount() {
        return this.proposedReceiverCount;
    }

    public void setProposedReceiverCount(int i2) {
        this.proposedReceiverCount = i2;
    }

    public BigDecimal getProposedQuantity() {
        return this.proposedQuantity;
    }

    public void setProposedQuantity(BigDecimal bigDecimal) {
        this.proposedQuantity = bigDecimal;
    }

    public String getCreatorType() {
        return this.creatorType;
    }

    public void setCreatorType(String str) {
        this.creatorType = str;
    }

    public String getThemeGuid() {
        return this.themeGuid;
    }

    public void setThemeGuid(String str) {
        this.themeGuid = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(String str) {
        this.creatorId = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public List<String> getRecipientList() {
        return this.recipientList;
    }

    public void setRecipientList(List<String> list) {
        this.recipientList = list;
    }

    public String getRecipientListType() {
        return this.recipientListType;
    }

    public void setRecipientListType(String str) {
        this.recipientListType = str;
    }

    public boolean isShowOtherRecipients() {
        return this.showOtherRecipients;
    }

    public void setShowOtherRecipients(boolean z) {
        this.showOtherRecipients = z;
    }

    public BigDecimal getMinQuantity() {
        return this.minQuantity;
    }

    public void setMinQuantity(BigDecimal bigDecimal) {
        this.minQuantity = bigDecimal;
    }

    public boolean isGamify() {
        return this.gamify;
    }

    public void setGamify(boolean z) {
        this.gamify = z;
    }

    public String getMerchantLogo() {
        return this.merchantLogo;
    }

    public void setMerchantLogo(String str) {
        this.merchantLogo = str;
    }

    public String toString() {
        return "CRJCreateLifafaReq{, name='" + this.name + '\'' + ", strategyType='" + this.strategyType + '\'' + ", distributionType='" + this.distributionType + '\'' + ", proposedReceiverCount=" + this.proposedReceiverCount + ", proposedQuantity=" + this.proposedQuantity + ", creatorType='" + this.creatorType + '\'' + ", themeGuid='" + this.themeGuid + '\'' + ", unit='" + this.unit + '\'' + ", creatorId='" + this.creatorId + '\'' + ", category='" + this.category + '\'' + ", recipientList=" + this.recipientList + ", recipientListType='" + this.recipientListType + '\'' + ", minQuantity=" + this.minQuantity + '}';
    }
}
