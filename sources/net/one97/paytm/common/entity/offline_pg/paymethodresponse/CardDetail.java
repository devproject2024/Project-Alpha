package net.one97.paytm.common.entity.offline_pg.paymethodresponse;

import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CardDetail implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private String cardId;
    private String cardNumber;
    private String cardType;
    private String createdOn;
    private String expiryDate;
    private String firstSixDigit;
    private HasLowSuccess hasLowSuccess;
    private IsDisabled isDisabled;
    private String lastFourDigit;
    private String status;
    private String updatedOn;
    private String userId;

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public String getFirstSixDigit() {
        return this.firstSixDigit;
    }

    public void setFirstSixDigit(String str) {
        this.firstSixDigit = str;
    }

    public String getLastFourDigit() {
        return this.lastFourDigit;
    }

    public void setLastFourDigit(String str) {
        this.lastFourDigit = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUpdatedOn() {
        return this.updatedOn;
    }

    public void setUpdatedOn(String str) {
        this.updatedOn = str;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(String str) {
        this.createdOn = str;
    }

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public void setHasLowSuccess(HasLowSuccess hasLowSuccess2) {
        this.hasLowSuccess = hasLowSuccess2;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
